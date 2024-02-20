package com.example.hello.Offer;

import java.util.HashSet;
import java.util.Set;

public class No48lengthOfLongestSubString {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    //滑动窗口
    public static int lengthOfLongestSubstring(String s) {
        //哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        //右指针，初始值为-1，相当于我们在字符串的左边界的左侧。还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                //左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                //不断移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            //从第i个到rk个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

}
