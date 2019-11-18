package com.liuyanzhao.sell.service.impl;


import com.liuyanzhao.sell.dao.ProductCategoryDao;
import com.liuyanzhao.sell.entity.ProductCategory;
import com.liuyanzhao.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * @Author: 言曌
 * @Date: 2017/11/11
 * @Time: 下午7:04
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryDao dao;

    @Override
    public ProductCategory findById(Integer categoryId) {
        return dao.findById(categoryId).orElse(null);
    }

    @Override
    public List<ProductCategory> findAll() {
        return dao.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return dao.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return dao.save(productCategory);
    }
}