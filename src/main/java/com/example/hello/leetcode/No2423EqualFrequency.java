package com.example.hello.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 孙浩林
 * @date: 4/29/23 16:40
 */
public class No2423EqualFrequency {
    public static void main(String[] args) {
        String word = "abcc";
        System.out.println(equalFrequency(word));
    }

        public static boolean equalFrequency(String word) {
            char[] s = word.toCharArray();
            int n = s.length;
            for (int i = 0; i < n; ++i) { // 枚举删除的字符
                Map<Character, Integer> cnt = new HashMap<Character, Integer>();
                for (int j = 0; j < n; ++j)
                    if (j != i)
                        cnt.merge(s[j], 1, Integer::sum); // 统计出现次数
                if (isSame(cnt)) // 出现次数都一样
                    return true;
            }
            return false;
        }

        private static boolean isSame(Map<Character, Integer> cnt) {
            int c0 = cnt.entrySet().iterator().next().getValue();
            for (int c : cnt.values())
                if (c != c0)
                    return false;
            return true;
        }


}
