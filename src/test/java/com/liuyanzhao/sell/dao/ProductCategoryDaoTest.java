package com.liuyanzhao.sell.dao;

import com.liuyanzhao.sell.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Anthor: chen
 * Date: 2019/11/15
 * Time: 13:25
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {

    @Autowired
    private ProductCategoryDao dao;

    @Test
    public  void  findOneTest(){
        ProductCategory productCategory = dao.findById(1).orElse(null);
        System.out.println(productCategory);
    }

    @Test
    //@Transactional
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("男生最爱4", 7);
        productCategory.setCreateTime(new Date());
        productCategory.setUpdateTime(new Date());
        ProductCategory result = dao.save(productCategory);
        Assert.assertNotNull(result);
    }

    @Test
    public void updateTest(){
        ProductCategory productCategory=dao.findById(14).orElse(null);
        productCategory.setCategoryName("饮");
        productCategory.setCategoryType(3);
        dao.save(productCategory);
    }
    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list= Arrays.asList(4,5,6);
        List<ProductCategory> result=dao.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }
}