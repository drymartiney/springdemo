package com.liuyanzhao.sell.service;

import com.liuyanzhao.sell.dto.OrderDTO;

/**
 * Anthor: chen
 * Date: 2019/12/6
 * Time: 15:23
 */
public interface PayService {
    void create(OrderDTO orderDTO);
}
