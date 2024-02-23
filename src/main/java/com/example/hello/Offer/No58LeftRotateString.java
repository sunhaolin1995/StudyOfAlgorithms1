package com.example.hello.Offer;

public class No58LeftRotateString {

    public static void main(String[] args) {
        String str="";int n =3;
        System.out.println(LeftRotateString(str, n));
    }

    public static String LeftRotateString(String str, int n) {
        if (str == null || str.length()<=1){
            return str;
        }
        // write code here
        int offset = n % (str.length());

        String sb1 = str.substring(offset, str.length() );
        String sb2 = str.substring(0, offset);
        return sb1 + sb2;
    }

}
