package com.liuyanzhao.sell.service;

import com.liuyanzhao.sell.dto.OrderDTO;
import org.springframework.util.StringUtils;

/**
 * Anthor: chen
 * Date: 2019/12/3
 * Time: 11:11
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);

}
