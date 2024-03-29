package com.liuyanzhao.sell.utils;

import com.liuyanzhao.sell.VO.ResultVO;

/**
 * Anthor: chen
 * Date: 2019/11/18
 * Time: 17:22
 */
public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(0);
        resultVO.setData(object);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }

}

