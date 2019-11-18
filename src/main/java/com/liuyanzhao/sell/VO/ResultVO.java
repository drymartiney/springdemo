package com.liuyanzhao.sell.VO;

import lombok.Data;

/**
 * Anthor: chen
 * Date: 2019/11/18
 * Time: 15:01
 */
@Data
public class ResultVO<T> {
    //状态编码
    private Integer code;

    //提示信息
    private String msg;

    //返回的内容
    private T data;
}
