package com.example.hello.leetcode;

import java.util.ArrayList;
import java.util.List;

public class No779kthGrammar {

    public static void main(String[] args) {
        System.out.println(kthGrammar(1,1));
    }


    public static int kthGrammar(int n, int k) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i <k ; i++) {
            list = getList(list);
        }
        return list.get(n);

    }

    public static List<Integer> getList(List<Integer> list){
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            if (list.get(i) == 0){
                list1.add(0);
                list1.add(1);
            }
            if (list.get(i) == 1){
                list1.add(1);
                list1.add(0);
            }
        }
        return list1;
    }
}
