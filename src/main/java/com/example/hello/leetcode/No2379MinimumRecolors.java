package com.example.hello.leetcode;

public class No2379MinimumRecolors {

    public static void main(String[] args) {
       String blocks = "WBWBBBW";
       int k =2;
        System.out.println(minimumRecolors(blocks,k));
    }

    public static int minimumRecolors(String blocks, int k) {
        int left =0,right =0,convert=0;
        for(int i=0;i<k;i++){
            if(blocks.charAt(i)=='W'){
                convert++;
            }
            right++;
        }
        int res = convert;
        while (right < blocks.length()) {
            convert += blocks.charAt(right) == 'W' ? 1 : 0;
            convert -= blocks.charAt(left) == 'W' ? 1 : 0;
            res = Math.min(res, convert);
            left++;
            right++;
        }
        return res;
    }

}
