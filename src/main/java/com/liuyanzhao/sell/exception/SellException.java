package com.liuyanzhao.sell.exception;

import com.liuyanzhao.sell.enums.ResultEnum;

/**
 * Anthor: chen
 * Date: 2019/11/29
 * Time: 15:39
 */
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();
    }

    public SellException(Integer code,String message){
        super(message);
        this.code=code;
    }
}
