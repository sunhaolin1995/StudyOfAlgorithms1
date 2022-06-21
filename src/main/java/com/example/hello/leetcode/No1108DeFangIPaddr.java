package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 2022/6/21 22:48
 */
public class No1108DeFangIPaddr {
    public static void main(String[] args) {
        String address = "255.100.50.0";
        String s = defangIPaddr(address);
        System.out.println(s);

    }

    public static String defangIPaddr(String address) {
        char[] chars = new char[address.length()];

        for (int i = 0; i <address.length() ; i++) {
            chars[i]=address.charAt(i);
        }
        String s = "";
        for (int i = 0; i <chars.length ; i++) {

            if (chars[i]=='.'){
                s=s+'['+chars[i]+']';
            }else {
                s=s+chars[i];
            }
        }
        return s;
    }
}
