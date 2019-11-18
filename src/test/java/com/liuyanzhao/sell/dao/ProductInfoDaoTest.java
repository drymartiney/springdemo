package com.liuyanzhao.sell.dao;

import com.liuyanzhao.sell.entity.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Anthor: chen
 * Date: 2019/11/15
 * Time: 16:44
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest {

    @Autowired
    private ProductInfoDao dao;

    @Test
    public void saveTest(){
        ProductInfo productInfo=new ProductInfo();
        productInfo.setProductId("12345");
        productInfo.setProductName("怡宝矿泉水");
        productInfo.setProductPrice(new BigDecimal(2.50));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("村天然，有点甜");
        productInfo.setProductIcon("http://xxx.com/xx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(4);
        productInfo.setCreateTime(new Date());
        productInfo.setUpdateTime(new Date());
        ProductInfo result= dao.save(productInfo);
        Assert.assertNotNull(result);
    }


    @Test
    public void findByProductStatus() {
        List<ProductInfo> result=dao.findByProductStatus(0);
        Assert.assertNotEquals(0,result.size());
    }
}