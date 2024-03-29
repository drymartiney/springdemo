package com.liuyanzhao.sell.entity;

import lombok.Data;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.print.DocFlavor;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Anthor: chen
 * Date: 2019/11/26
 * Time: 9:49
 */
@Entity
@Data
public class OrderDetail {

    @Id
    private String detailId;

    private String orderId;

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productQuantity;

    private String  productIcon;

    @Column(insertable = false,updatable = false)
    private Date createTime;

    @Column(insertable = false)
    private Date update_time;
}
