package com.liuyanzhao.sell.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 购物车
 * Anthor: chen
 * Date: 2019/11/29
 * Time: 15:56
 */
@Data
@AllArgsConstructor
public class CartDTO {
    //商品ID
    private String productId;

    //数量
    private Integer productQuantity;
}
