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
        System.out.println(new Solution().numJewelsInStones("ac","aAAAABBBCCcc"));
    }

    static class Solution {
        public int numJewelsInStones(String J, String S) {
            int num=0;
            for(char j:J.toCharArray()){
                for (char s:S.toCharArray()){
                    if(j==s){
                        num++;
                    }
                }
            }
            return num;
        }
    }
}
