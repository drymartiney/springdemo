package com.liuyanzhao.sell.service.impl;

import com.liuyanzhao.sell.converter.OrderMaster2OrderDTOConverter;
import com.liuyanzhao.sell.dao.OrderDetailDao;
import com.liuyanzhao.sell.dao.OrderMasterDao;
import com.liuyanzhao.sell.dto.CartDTO;
import com.liuyanzhao.sell.dto.OrderDTO;
import com.liuyanzhao.sell.entity.OrderDetail;
import com.liuyanzhao.sell.entity.OrderMaster;
import com.liuyanzhao.sell.entity.ProductInfo;
import com.liuyanzhao.sell.enums.OrderStatusEnum;
import com.liuyanzhao.sell.enums.PayStatusEnum;
import com.liuyanzhao.sell.enums.ResultEnum;
import com.liuyanzhao.sell.exception.SellException;
import com.liuyanzhao.sell.service.OrderService;
import com.liuyanzhao.sell.service.ProductService;
import com.liuyanzhao.sell.utils.KeyUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Order;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import sun.security.util.KeyUtil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Anthor: chen
 * Date: 2019/11/29
 * Time: 15:10
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private OrderDetailDao orderDetailDao;
    @Autowired
    private OrderMasterDao orderMasterDao;
    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId= KeyUtils.genUniqueKey();
        BigDecimal orderAmount=new BigDecimal(BigInteger.ZERO);
        //1.查询商品 (数量，价格)
        for (OrderDetail orderDetail:orderDTO.getOrderDetailList()){
            ProductInfo productInfo=productService.findOne(orderDetail.getProductId());
            if (productInfo==null){
                throw  new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //2.计算总价
            orderAmount=productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);
            //订单详情入库
            orderDetail.setDetailId(KeyUtils.genUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo,orderDetail);
            orderDetailDao.save(orderDetail);
        }

        //3.写入订单数据库(orderMaster和orderDetail)
        OrderMaster orderMaster=new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterDao.save(orderMaster);
        //4.口库存lanmeda表达式
        List<CartDTO> cartDTOList=orderDTO.getOrderDetailList().stream().map(e ->
                new CartDTO(e.getProductId(),e.getProductQuantity())).collect(Collectors.toList());
        productService.decreaseStock(cartDTOList);
        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        OrderMaster orderMaster=orderMasterDao.findById(orderId).orElse(null);
        if (orderMaster==null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        List<OrderDetail> orderDetailList=orderDetailDao.findByOrOrderId(orderId);
        if (CollectionUtils.isEmpty(orderDetailList)) {
            throw new SellException(ResultEnum.ORDER_DETAIL_NOT_EXIST);
        }

        OrderDTO orderDTO=new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        Page<OrderMaster> orderMasterPage=orderMasterDao.findByBuyerOpenid(buyerOpenid,pageable);
        List<OrderDTO> orderDTOList=OrderMaster2OrderDTOConverter.convert(orderMasterPage.getContent());

        Page<OrderDTO> orderDTOPage=new PageImpl<OrderDTO>(orderDTOList,pageable,orderMasterPage.getTotalElements());

        return orderDTOPage;
    }

    @Override
    @Transactional
    public OrderDTO cancel(OrderDTO orderDTO) {
        OrderMaster orderMaster=new OrderMaster();
        //判断订单状态
        if (!orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())){
            log.error("【取消订单】订单状态不正确，orderId={},orderStatus={}",orderDTO.getOrderId(),orderDTO.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }

        //修改订单状态
        orderDTO.setOrderStatus(OrderStatusEnum.CANCEL.getCode());
        BeanUtils.copyProperties(orderDTO,orderMaster);
        OrderMaster updateResult=orderMasterDao.save(orderMaster);
        if (updateResult==null){
            log.error("【取消订单】更新失败，orderMaster={}",orderMaster);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }
        //返回库存
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【取消订单】订单中五商品详情，orderDTO={}",orderDTO);
            throw new SellException(ResultEnum.ORDER_DETAIL_EMPTY);
        }
        List<CartDTO> cartDTOList=orderDTO.getOrderDetailList().stream()
                .map(e->new CartDTO(e.getProductId(),e.getProductQuantity()))
                .collect(Collectors.toList());
        productService.increaseStock(cartDTOList);
        //如果已支付，需要退款
        if (orderDTO.getPayStatus().equals(PayStatusEnum.SUCCESS.getCode())){
            //TODO
        }
        return orderDTO;
    }

    @Override
    @Transactional
    public OrderDTO finish(OrderDTO orderDTO) {
        //判断订单状态
        if (orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())){
            log.error("【完结订单】订单状态不正确,orderId={},orderStatus={}",orderDTO.getOrderId(),orderDTO.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }

        //修改状态
        orderDTO.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
        OrderMaster orderMaster=new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        OrderMaster updateResult=orderMasterDao.save(orderMaster);
        if (updateResult==null){
            log.error("【完结订单】更新失败，orderMaster={}",orderMaster);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }
        return orderDTO;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        //判断订单状态
        if (orderDTO.getOrderStatus().equals(OrderStatusEnum.NEW.getCode())){
            log.error("【订单支付成功】订单状态不正确,orderId={},orderStatus={}",orderDTO.getOrderId(),orderDTO.getOrderStatus());
            throw new SellException(ResultEnum.ORDER_STATUS_ERROR);
        }
        //判断支付状态
        if (!orderDTO.getPayStatus().equals(PayStatusEnum.WAIT.getCode())){
            log.error("【订单支付完成】订单支付状态不正确,orderDTO={}",orderDTO);
            throw new SellException(ResultEnum.ORDER_PAID_STATUS_ERROR);
        }
        //修改支付状态
        orderDTO.setPayStatus(PayStatusEnum.SUCCESS.getCode());
        OrderMaster orderMaster=new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        OrderMaster updateResult=orderMasterDao.save(orderMaster);
        if (updateResult==null){
            log.error("【订单支付完成】更新失败，orderMaster={}",orderMaster);
            throw new SellException(ResultEnum.ORDER_UPDATE_FAIL);
        }
        return orderDTO;
    }
}
