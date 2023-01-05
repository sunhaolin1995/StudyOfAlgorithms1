package com.example.hello.leetcode;

public class No70climbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(44));
    }

   /* public static int climbStairs(int n) {
      if (n==1){
          return 1 ;
      }
      if ( n== 2){
          return 2;
      }
      if (n >=3){
          return climbStairs(n-1)+climbStairs(n-2);
      }
      return 0;
    }*/

    public static int climbStairs(int n) {
        int o =0 ,p=0 ,q = 1;
        for (int i = 1; i <=n ; ++i) {
            o=p;
            p=q;
            q=o+p;
        }
        return q;
    }
}
