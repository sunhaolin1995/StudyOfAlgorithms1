package com.example.hello.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author 孙浩林
 * @date: 12/16/23 14:24
 */
public class No71SimplifyPath {
    public static void main(String[] args) {
        String path = "/a//b////c/d//././/..";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        Deque<String> cvt = new ArrayDeque<>();
        String[] splits = path.split("/");
        for (int i = 0; i < splits.length; i++) {
            String split = splits[i];
            if (split.equals(".") || split.equals("")) {
            } else if (split.equals("..")) {
                if (!cvt.isEmpty()) {
                    cvt.pollLast();
                }
            } else {
                cvt.add(split);
            }
        }

        String res = "";
        if (cvt.size() ==0){
            return "/";
        }
        while (!cvt.isEmpty()) {
            res =res+ "/" + cvt.pop();
        }
        return res;
    }
}
