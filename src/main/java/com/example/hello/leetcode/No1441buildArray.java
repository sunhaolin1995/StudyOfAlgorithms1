package com.example.hello.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 孙浩林
 * @date: 2022/10/15 16:02
 */
public class No1441buildArray {

    public static void main(String[] args) {
      int[] array ={2,3,4};
        List<String> list = buildArray(array, 4);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    public static List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int j=0;
        for (int i = 0; i < target.length ; i++) {
            if (target[i] == j+1 ){
                result.add("Push");
                j++;
            }else if(target[i] != j+1){
                while (target[i] !=j+1 ){
                    result.add("Push");
                    result.add("Pop");
                    j++;
                }
                result.add("Push");
                j++;
            }
        }
     return result;

    }
}
