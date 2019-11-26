package com.liuyanzhao.sell;

import java.lang.reflect.Field;

/**
 * Anthor: chen
 * Date: 2019/11/26
 * Time: 12:38
 */
public class test {
    public int[] a={1,2,3};
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("com.liuyanzhao.sell.test");
            test p = (test) clazz.newInstance();
            Field filed = clazz.getField("a");
            Class type = filed.getType();
            System.out.println(type);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
