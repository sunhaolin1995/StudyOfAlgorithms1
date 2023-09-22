package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 9/21/23 13:27
 */
public class No6Convert {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String convert = convert(s, numRows);
        System.out.println(convert);
    }

    public static String convert(String s, int numRows) {
        //先计算要几乘以几的矩阵
        int period = numRows + numRows - 2;
        int length = s.length();

        if ( numRows == 1 || numRows >= length){
            return s;
        }


        int column = ((length + period - 1) / period) * (numRows - 1);
        char[][] convert = new char[numRows][column];

        for (int i = 0, x = 0, y = 0; i < length; i++) {
            convert[x][y] = s.charAt(i);
            if (i % period < numRows -1){
                ++x;
            }else {
                --x;
                ++y;
            }
        }

        StringBuffer ans = new StringBuffer();
        for (char[] row: convert) {
            for (char ch:row) {
                if (ch != 0){
                    ans.append(ch);
                }
            }
        }

        return ans.toString();
    }

}
