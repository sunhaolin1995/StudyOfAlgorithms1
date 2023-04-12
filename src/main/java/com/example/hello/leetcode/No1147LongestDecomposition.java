package com.example.hello.leetcode;

public class No1147LongestDecomposition {

    public static void main(String[] args) {
        String s = "asdfresd";
        System.out.println(longestDecomposition(s));
    }

    public static int longestDecomposition(String text) {
        int ans = 0;
        while (!text.isEmpty()){
            int i =1,n=text.length();
            while ( i<= n && !text.substring(0,i).equals(text.substring(n-i))){
                ++i;
            }
            if (i>n/2){
                ++ans;
                break;
            }
            ans = ans +2;
            text=text.substring(i,n-i);
        }
        return ans;

    }


}
