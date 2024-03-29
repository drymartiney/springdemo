package com.liuyanzhao.sell.entity;

import com.liuyanzhao.sell.enums.OrderStatusEnum;
import com.liuyanzhao.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Anthor: chen
 * Date: 2019/11/18
 * Time: 17:44
 */
@Entity
@DynamicUpdate
@Data
public class OrderMaster {

    //订单Id
    @Id
    private String orderId;

    //买家姓名
    private String buyerName;

    //买家手机号
    private String buyerPhone;

    private String buyerAddress;

    //买家微信Openid
    private String buyerOpenid;

    //订单总金额
    private BigDecimal orderAmount;

    //订单状态，默认为新下单
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    //支付状态，默认为0未支付
    private Integer payStatus= PayStatusEnum.WAIT.getCode();

    //创建时间
    @Column(insertable = false,updatable = false)
    private Date createTime;

    //更新时间
    @Column(insertable = false)
    private Date updateTime;
//
//    @Transient
//    private List<OrderDetail> orderDetailList;
}
