package com.example.hello.Algorithms.champerOne;

/**
 * @author 孙浩林
 * @date: 2022/9/17 10:47
 */
public class no1_1_6_4Recursion {
    public static void main(String[] args) {

    }

    //二分法的另一种实现
    public static int rank(int key , int[] a){
        return rank(key,a,0,a.length-1);
    }

    public static int rank(int key ,int[] a,int lo ,int hi){
        //如果key存在a[]中，他的索引不会小于lo且不会大于hi；
        if (lo > hi){
            return -1;
        }
        int mid = lo + (hi-lo)/2;
        if (key < a[mid]){
         return rank(key,a,lo,mid-1);
        }else if (key > a[mid]){
            return rank(key,a,mid+1,hi);
        }else {
            return mid;
        }



    }

}
