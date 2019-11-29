package com.liuyanzhao.sell.service;

import com.liuyanzhao.sell.dto.CartDTO;
import com.liuyanzhao.sell.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Anthor: chen
 * Date: 2019/11/16
 * Time: 10:44
 */
public interface ProductService {
    //查询一个商品
    ProductInfo findOne(String productId);

    //查询所有上架的商品
    List<ProductInfo> findUpAll();

    /**
     * 查询所有记录，用于后台
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    //添加商品
    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);
    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);
}
