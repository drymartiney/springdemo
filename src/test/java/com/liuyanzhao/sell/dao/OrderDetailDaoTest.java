package com.liuyanzhao.sell.dao;

import com.liuyanzhao.sell.entity.OrderDetail;
import org.aspectj.weaver.ast.Or;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Anthor: chen
 * Date: 2019/11/29
 * Time: 14:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class OrderDetailDaoTest {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Test
    public void save(){
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setDetailId("1234567810");
        orderDetail.setOrderId("1111112");
        orderDetail.setProductPrice(new BigDecimal(2.2));
        orderDetail.setProductIcon("http://xxx.jpg");
        orderDetail.setProductId("11111112");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductQuantity(3);
        OrderDetail result=orderDetailDao.save(orderDetail);
        Assert.assertNotNull(result);
    }
    @Test
    void findByOrOrderId() {
        List<OrderDetail> orderDetailList=orderDetailDao.findByOrOrderId("1111112");
        Assert.assertNotEquals(0,orderDetailList.size());
    }
}