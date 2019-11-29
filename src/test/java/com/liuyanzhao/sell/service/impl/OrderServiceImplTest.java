package com.liuyanzhao.sell.service.impl;

import com.liuyanzhao.sell.dto.OrderDTO;
import com.liuyanzhao.sell.entity.OrderDetail;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Anthor: chen
 * Date: 2019/11/29
 * Time: 16:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;
    private static String BUYER_OPENID="110110";
    private static String ORDER_ID="1575016897649559795";
    @Test
    void create() {
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setBuyerName("陈猫粮");
        orderDTO.setBuyerAddress("慕课网");
        orderDTO.setBuyerPhone("123456789");
        orderDTO.setBuyerOpenid(BUYER_OPENID);
        //购物车
        List<OrderDetail> orderDetailList=new ArrayList<>();
        OrderDetail o1=new OrderDetail();
        o1.setProductId("123457");
        o1.setProductQuantity(1);
        orderDetailList.add(o1);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result=orderService.create(orderDTO);
        System.out.println(result);
    }

    @Test
    void findOne() {
        OrderDTO result=orderService.findOne(ORDER_ID);
        System.out.println(result);
        Assert.assertEquals(ORDER_ID,result.getOrderId());
    }

    @Test
    void findList() {
        PageRequest request=PageRequest.of(0,2);
        Page<OrderDTO> orderDTOPage=orderService.findList(BUYER_OPENID,request);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

    @Test
    void cancel() {
    }

    @Test
    void finish() {
    }

    @Test
    void paid() {
    }
}