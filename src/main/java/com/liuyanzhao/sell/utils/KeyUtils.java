package com.liuyanzhao.sell.utils;

import java.util.Random;

/**
 * Anthor: chen
 * Date: 2019/11/29
 * Time: 15:44
 */
public class KeyUtils {

    /**
     * 产生独一无二的key
     */

    public static synchronized  String genUniqueKey(){
        Random random=new Random();
        int number=random.nextInt(900000)+100000;
        return System.currentTimeMillis()+String.valueOf(number);
    }
}
