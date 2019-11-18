package com.liuyanzhao.sell.service.impl;

import com.liuyanzhao.sell.dao.ProductInfoDao;
import com.liuyanzhao.sell.entity.ProductInfo;
import com.liuyanzhao.sell.enums.ProductStatusEnum;
import com.liuyanzhao.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Anthor: chen
 * Date: 2019/11/16
 * Time: 10:49
 */
@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductInfoDao productInfoDao;
    @Override
    public ProductInfo findOne(String productId) {
        return productInfoDao.findById(productId).orElse(null);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoDao.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoDao.save(productInfo);
    }
}
