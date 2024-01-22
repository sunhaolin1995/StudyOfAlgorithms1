package com.example.hello.Offer;

/**
 * @author 孙浩林
 * @date: 1/22/24 13:30
 */
public class No20IsNumeric {

    public static void main(String[] args) {
        String str = "123.45e+6";
        System.out.println(isNumeric(str));
    }

    public static boolean isNumeric(String str) {
        int n = str.length();
        int index = 0;
        boolean hasNum = false, hasE = false;
        boolean hasSign = false, hasDot = false;
        while (index < n && str.charAt(index) == ' ') index++;
        while (index < n) {
            while (index < n && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
                index++;
                hasNum = true;
            }
            if (index == n) {
                break;
            }
            char c = str.charAt(index);
            if (c == 'e' || c == 'E') {
                if (hasE || !hasNum) {
                    return false;
                }
                hasE = true;
                hasNum = false;
                hasSign = false;
                hasDot = false;
            } else if (c == '+' || c == '-') {
                if (hasSign || hasNum || hasDot) {
                    return false;
                }
                hasSign = true;
            } else if (c == '.') {
                if (hasDot || hasE) {
                    return false;
                }
                hasDot = true;
            } else if (c == ' ') {
                break;
            } else {
                return false;
            }
            index++;
        }
        while (index < n && str.charAt(index) == ' ') index++;
        return hasNum && index == n;


    }

}




