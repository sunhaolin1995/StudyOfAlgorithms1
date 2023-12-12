package com.example.hello.leetcode;


import java.util.*;

public class No49GroupAnagrams {

    public static void main(String[] args) {
        String[] strs = new String[]{"",""};
        List<List<String>> lists = groupAnagrams(strs);
        for (List<String> strings : lists) {
            for (String string :
                    strings) {
                System.out.println(string);
            }
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        Map<String, List<String>> convert = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            String sortStr = sort(str);

            if (convert.containsKey(sortStr)) {
                List<String> strings = convert.get(sortStr);
                strings.add(str);
                convert.put(sortStr, strings);
            } else {
                List<String> cvt = new ArrayList<>();
                cvt.add(str);
                convert.put(sortStr, cvt);
            }
        }
        for (String str : convert.keySet()) {
            List<String> strings = convert.get(str);
            res.add(strings);
        }
        return res;
    }


    public static String sort(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }


    public static boolean isSimilar(String source, String target) {
        Map<Character, Integer> cvt = new HashMap<>();
        if (source.length() != target.length()) {
            return false;
        }
        for (int i = 0; i < source.length(); i++) {
            cvt.put(source.charAt(i), cvt.getOrDefault(source.charAt(i), 0) + 1);
        }

        for (int i = 0; i < target.length(); i++) {
            cvt.put(target.charAt(i), cvt.getOrDefault(target.charAt(i), 0) - 1);
        }
        for (Character ch : cvt.keySet()) {
            if (cvt.get(ch) != 0) {
                return false;
            }
        }
        return true;
    }


}
