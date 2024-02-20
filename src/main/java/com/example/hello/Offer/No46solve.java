package com.example.hello.Offer;

public class No46solve {

    public static void main(String[] args) {
        String nums = "31717126241541717";
        System.out.println(solve(nums));
    }



    /*public static int solve (String nums) {
        int n = nums.length();
        int[] dp = new int[n+1];
        dp[0] =1;
        dp[1] =1;
        for (int i = 2; i <=n ; i++) {
            //将当前数字和前一个数字组成的两位数
            int twoDigits = Integer.parseInt(nums.substring(i-2,i));
            //如果两位数在10-25之间，则可以选择分开翻译或者合并翻译
            if (twoDigits >= 10 && twoDigits<=25){
                dp[i] = dp[i-1] + dp[i-2];
            }else {
                dp[i] = dp[i-1];
            }
        }
        return dp[n];
    }
*/


        public static int solve(String nums) {
            // write code here
            int n = nums.length();
            int[] res = new int[n + 1];
            res[0] = 1;
            for (int i = 0; i < n; i++) {
                if (nums.charAt(i) != '0') { // 一个数字译为一个字符
                    res[i + 1] += res[i];
                }
                // 两个数字译为一个字符
                if (i > 0 && nums.charAt(i - 1) != '0' && (nums.charAt(i - 1) - '0') * 10 + (nums.charAt(i) - '0') <= 26) {
                    res[i + 1] += res[i - 1];
                }
            }
            return res[n];
        }


}
