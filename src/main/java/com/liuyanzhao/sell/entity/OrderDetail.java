package com.liuyanzhao.sell.entity;

import lombok.Data;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.print.DocFlavor;
import java.math.BigDecimal;

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

    private BigDecimal prodcutPrice;

    private Integer productQuantity;

    private String  productIcon;
}
