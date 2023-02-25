package com.example.hello.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 孙浩林
 * @date: 2/25/23 11:27
 */
public class no1247minimumSwap {
    public static void main(String[] args) {
        String s1 = "xxyyxyxyxx",s2 = "xyyxyxxxyx";
        System.out.println(minimumSwap(s1,s2));
    }

    public static int minimumSwap(String s1, String s2) {
        int xy = 0;
        int yx = 0;
        char c1;
        char c2;

        for (int i = 0; i < s1.length(); i++) {

            c1 = s1.charAt(i);
            c2 = s2.charAt(i);
            //分别统计xy和yx的对数
            if (c1 == 'x' && c2 == 'y'){
                xy++;
            }
            if (c1 == 'y' && c2 == 'x'){
                yx++;
            }
        }

        if ((xy+yx) % 2 ==1){
            return -1;
        }
        return xy / 2 + yx / 2 + (xy % 2 + yx % 2);

    }

}
