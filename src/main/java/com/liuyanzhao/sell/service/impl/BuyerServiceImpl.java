package com.liuyanzhao.sell.service.impl;

import com.liuyanzhao.sell.dto.OrderDTO;
import com.liuyanzhao.sell.enums.ResultEnum;
import com.liuyanzhao.sell.exception.SellException;
import com.liuyanzhao.sell.service.BuyerService;
import com.liuyanzhao.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Anthor: chen
 * Date: 2019/12/3
 * Time: 11:16
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private OrderService orderService;
    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid,orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO=checkOrderOwner(openid,orderId);
        if (orderDTO==null){
            log.error("【取消订单】查不到该顶顶那，orderId={}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid,String orderId){
        OrderDTO orderDTO=orderService.findOne(orderId);
        if (orderDTO==null){
            return null;
        }
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error("【查询订单】订单的openid不一致.openid={},orderDTO={}",openid,orderDTO.getBuyerOpenid());
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
