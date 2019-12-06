package com.liuyanzhao.sell.controller;

import com.liuyanzhao.sell.dto.OrderDTO;
import com.liuyanzhao.sell.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Anthor: chen
 * Date: 2019/12/6
 * Time: 15:21
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/create")
    public void create(@RequestParam("orderId")String order,
                       @RequestParam("returnUrl")String returnUrl){
        //1.查询订单
        OrderDTO orderDTO=orderService.findOne(order);
    }
}
