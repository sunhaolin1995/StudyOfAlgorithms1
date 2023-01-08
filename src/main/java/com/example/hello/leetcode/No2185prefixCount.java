package com.example.hello.leetcode;

public class No2185prefixCount {

    public static void main(String[] args) {
        String[] words = {"leetcode","win","loops","success"};
        String pref = "code";
        System.out.println(prefixCount(words,pref));
    }

    public static int prefixCount(String[] words, String pref) {
        /*int result = 0;

        for (int i = 0; i < words.length ; i++) {
            if (pref.length() <= words[i].length()){
                int a =0 ,b=0;
                while (b < pref.length()){
                    if (pref.charAt(a) ==  words[i].charAt(a) ){
                        a++;
                        b++;
                    }else {
                        b++;
                    }
                }
                if (a == pref.length()){
                    result++;
                }

            }

        }
        return result;*/

        int res = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                res++;
            }
        }
        return res;


    }


}
