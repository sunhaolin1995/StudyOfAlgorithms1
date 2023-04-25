package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 4/25/23 14:33
 */
public class No2418SortPeople {

    public static void main(String[] args) {
        String[] names = {"Mary","John","Emma"};
        int[] heights = {180,165,170};
        String[] strings = sortPeople(names, heights);
        for (String s:strings) {
            System.out.println(s);
        }
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        for (int i = 0; i < heights.length; i++) {
            for (int j = i; j < heights.length ; j++) {
                if (heights[i] <= heights[j]){
                    int temp = heights[i];
                    heights[i] = heights[j];
                    heights[j] = temp;

                    String tempStr = names[i];
                    names[i] = names[j];
                    names[j] = tempStr;

                }
            }
        }
        return names;
    }

}
