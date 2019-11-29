package com.liuyanzhao.sell.dao;

import com.liuyanzhao.sell.entity.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Anthor: chen
 * Date: 2019/11/26
 * Time: 10:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {

    @Autowired
    private OrderMasterDao orderMasterDao;

    @Test
    public void saveTest(){
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerAddress("慕课网");
        orderMaster.setBuyerPhone("12312341234");
        orderMaster.setBuyerOpenid("110110");
        orderMaster.setOrderAmount(new BigDecimal(2.3));

        OrderMaster result=orderMasterDao.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void updateTest(){
        OrderMaster orderMaster=orderMasterDao.findById("123456").orElse(null);
        orderMaster.setBuyerName("师兄12");

        OrderMaster result=orderMasterDao.save(orderMaster);
        Assert.assertNotNull(result);
    }
}