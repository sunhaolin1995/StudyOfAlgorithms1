package com.example.hello.Offer;

/**
 * @author 孙浩林
 * @date: 4/14/23 17:04
 */
public class No5ReplaceSpace {

    public static void main(String[] args) {
        String s = "We are happy." ;
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {
        return s.replace(" ","%20");
    }

}
