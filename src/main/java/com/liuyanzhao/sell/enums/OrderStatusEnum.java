package com.liuyanzhao.sell.enums;

import lombok.Data;
import lombok.Getter;

/**
 * Anthor: chen
 * Date: 2019/11/18
 * Time: 18:02
 */
@Getter
public enum OrderStatusEnum {
    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消"),
    ;

    private Integer code;

    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
