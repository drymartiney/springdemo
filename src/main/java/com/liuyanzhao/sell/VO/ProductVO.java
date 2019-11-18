package com.liuyanzhao.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * 商品（包含类目）
 * Anthor: chen
 * Date: 2019/11/18
 * Time: 15:12
 */
@Data
public class ProductVO {

    //指定返回给前端的名字
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
