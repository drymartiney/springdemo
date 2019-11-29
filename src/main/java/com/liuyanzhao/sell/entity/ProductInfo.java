package com.liuyanzhao.sell.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Anthor: chen
 * Date: 2019/11/15
 * Time: 16:02
 */
@Entity
@DynamicUpdate
@Data
public class ProductInfo {
    //商品编号
    @Id
    private String productId;

    //商品名字
    private String productName;

    //商品价格
    private BigDecimal productPrice;

    //商品库存量
    private Integer productStock;
    //商品描述
    private String productDescription;

    //商品小图
    private String productIcon;

    //商品状态，0正常，1下架
    private Integer productStatus;

    //商品分类编号
    private Integer categoryType;

    //创建时间
    @Column(insertable = false)
    private Date createTime;

    //更新时间
    @Column(insertable = false)
    private Date updateTime;


    public ProductInfo() {
    }
}
