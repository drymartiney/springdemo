package com.liuyanzhao.sell;

import java.util.ArrayList;
import java.util.List;

/**
 * Anthor: chen
 * Date: 2019/11/26
 * Time: 12:38
 */
public class test {
    public static void main(String[] args) {
        List<List<String>> data=new ArrayList<>();
        List<String> data1=new ArrayList<>();
        List<String> data2=new ArrayList<>();
        data.add(data1);
        data.add(data2);
        int x=0;
        for (int i=0;i<10;i++){
            x=i%2;
            data.get(x).add("num"+i);
        }
        System.out.println(data);
    }
}
