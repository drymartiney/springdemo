package com.liuyanzhao.sell.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Anthor: chen
 * Date: 2019/12/6
 * Time: 16:48
 */
public class JsonUtil {
    public static String toJson(Object object){
        GsonBuilder gsonBuilder=new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson=gsonBuilder.create();
        return gson.toJson(object);
    }
}
