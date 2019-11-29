package com.liuyanzhao.sell.dto;

import com.liuyanzhao.sell.entity.OrderDetail;
import com.liuyanzhao.sell.enums.OrderStatusEnum;
import com.liuyanzhao.sell.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Anthor: chen
 * Date: 2019/11/29
 * Time: 15:06
 * 数据传输层
 */
@Data
public class OrderDTO {

    //订单Id
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
    private Integer orderStatus;

    //支付状态，默认为0未支付
    private Integer payStatus;

    //创建时间
    @Column(insertable = false,updatable = false)
    private Date createTime;

    //更新时间
    @Column(insertable = false)
    private Date updateTime;

    private List<OrderDetail> orderDetailList;
}
