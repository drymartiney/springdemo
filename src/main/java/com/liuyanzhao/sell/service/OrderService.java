package com.liuyanzhao.sell.service;

import com.liuyanzhao.sell.dto.OrderDTO;
import com.liuyanzhao.sell.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Anthor: chen
 * Date: 2019/11/29
 * Time: 15:04
 */
public interface OrderService {

    //创建订单
    OrderDTO create(OrderDTO orderDTO);

    //查询订单
    OrderDTO findOne(String orderId);

    //查询订单列表
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    //取消订单
    OrderDTO cancel(OrderDTO orderDTO);

    //完结订单
    OrderDTO finish(OrderDTO orderDTO);

    //支付订单
    OrderDTO paid(OrderDTO orderDTO);
}
