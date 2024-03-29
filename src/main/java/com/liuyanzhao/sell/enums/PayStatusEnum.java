package com.liuyanzhao.sell.enums;

import lombok.Getter;

/**
 * Anthor: chen
 * Date: 2019/11/18
 * Time: 18:04
 */
@Getter
public enum PayStatusEnum {

    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功")
    ;

    private Integer code;

    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
