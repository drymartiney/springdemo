package com.liuyanzhao.sell.dao;

import com.liuyanzhao.sell.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Anthor: chen
 * Date: 2019/11/15
 * Time: 16:08
 */
public interface ProductInfoDao extends JpaRepository<ProductInfo,String>{
    //根据商品装填获取商品列表
    List<ProductInfo> findByProductStatus(Integer prodcutStatus);
}
