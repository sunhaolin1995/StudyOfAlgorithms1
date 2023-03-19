package com.example.hello.leetcode;


import java.util.*;

/**
 * @author 孙浩林
 * @date: 3/19/23 10:55
 */
public class No1625FindLexSmallestString {

    public static void main(String[] args) {
        String s = "5525";
        int a = 9, b = 2;
        System.out.println(findLexSmallestString(s, a, b));
    }

    //第一种答案，用DFS来做
    public static String findLexSmallestString(String s, int a, int b) {


        Deque<String> q = new ArrayDeque<>();
        q.offer(s);
        Set<String> vis = new HashSet<>();
        vis.add(s);
        String ans = s;
        int n = s.length();
        while (!q.isEmpty()) {
            s = q.poll();
            if (ans.compareTo(s) > 0) {
                ans = s;
            }
            char[] cs = s.toCharArray();

            for (int i = 1; i < n; i = i + 2) {
                cs[i] = (char) (((cs[i] - '0' + a) % 10) + '0');
            }
            String t1 = String.valueOf(cs);
            String t2 = s.substring(b)+s.substring(0,b);

            for (String t : com.sun.tools.javac.util.List.of(t1, t2)) {
                if (vis.add(t)) {
                    q.offer(t);
                }
            }
        }
        return ans;

    }








}
