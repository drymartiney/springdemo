package com.liuyanzhao.sell.service;

import com.liuyanzhao.sell.entity.ProductCategory;

import java.util.List;

/**
 * 类目
 * Anthor: chen
 * Date: 2019/11/15
 * Time: 14:31
 */
public interface CategoryService {
    //查询一条数据
    ProductCategory findById(Integer categoryId);

    //查询所有记录
    List<ProductCategory> findAll();

    //查询分类列表的分类
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    //添加分类
    ProductCategory save(ProductCategory productCategory);

}
