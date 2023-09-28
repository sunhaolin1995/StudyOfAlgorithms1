package com.example.hello.leetcode;

import java.util.Arrays;

/**
 * @author 孙浩林
 * @date: 9/28/23 14:56
 */
public class No383canConstruct {

    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));

    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] ransomNoteCharArray = ransomNote.toCharArray();
        char[] magazineCharArray = magazine.toCharArray();
        Arrays.sort(ransomNoteCharArray);
        Arrays.sort(magazineCharArray);

        int left = 0, right = 0;
        while (right < magazineCharArray.length) {
            if (left == ransomNoteCharArray.length){
                return true;
            }
            if (ransomNoteCharArray[left] == magazineCharArray[right]){
                left++;
                right++;
            }else {
                right++;
            }
        }
        return left==ransomNoteCharArray.length;

    }

}
