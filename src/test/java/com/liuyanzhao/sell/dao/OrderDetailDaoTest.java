package com.liuyanzhao.sell.dao;

import com.liuyanzhao.sell.entity.OrderMaster;
import org.junit.Assert;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Anthor: chen
 * Date: 2019/11/26
 * Time: 10:33
 */
class OrderDetailDaoTest {

    @Autowired
    private OrderMasterDao orderMasterDao;

    @Test
    public void saveTest(){
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerAddress("慕课网");
        orderMaster.setBuyerPhone("12312341234");
        orderMaster.setBuyerOpenId("110110");
        orderMaster.setOrderAmount(new BigDecimal(2.3));

        OrderMaster result=orderMasterDao.save(orderMaster);
        Assert.assertNotNull(result);
    }
    @Test
    void findByOrOrderId() {
    }
}