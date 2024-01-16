package com.example.hello.Offer;

/**
 * @author 孙浩林
 * @date: 4/14/23 17:04
 */
public class No5ReplaceSpace {

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {

        int blankNum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==' '){
                blankNum++;
            }
        }
        char[] newString = new char[s.length() + 2 * blankNum];

        int pre = s.length() - 1, next = s.length() + 2 * blankNum - 1;
        char[] oldCharArray = s.toCharArray();
        while (pre >= 0) {
            if (oldCharArray[pre] != ' ') {
                newString[next] = oldCharArray[pre];
                next--;
                pre--;
            } else {
                newString[next] ='0';
                newString[next-1]='2';
                newString[next-2]='%';
                pre--;
                next=next-3;
            }

        }
        return new String(newString);
    }

    /*public static String replaceSpace(String s) {
        return s.replace(" ","%20");
    }*/

}
