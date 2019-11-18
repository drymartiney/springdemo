package com.liuyanzhao.sell.dao;

import com.liuyanzhao.sell.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Anthor: chen
 * Date: 2019/11/15
 * Time: 13:13
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
