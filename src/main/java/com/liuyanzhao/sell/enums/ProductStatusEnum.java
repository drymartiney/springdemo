package com.liuyanzhao.sell.enums;

import lombok.Getter;

/**
 * Anthor: chen
 * Date: 2019/11/16
 * Time: 10:58
 */

@Getter
public enum ProductStatusEnum {
    UP(0,"在架状态"),
    DOWN(1,"下架状态"),
    ;

    private Integer code;

    private String msg;

    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
