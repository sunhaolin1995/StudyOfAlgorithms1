package com.example.hello.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 孙浩林
 * @date: 9/28/23 14:56
 */
public class No383canConstruct {

    public static void main(String[] args) {
        String ransomNote = "aas", magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));

    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> cvt = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (cvt.containsKey(c)){
                cvt.put(c,cvt.get(c)+1);
            }else {
                cvt.put(c,1);
            }
        }
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if (cvt.containsKey(c)){
                if (cvt.get(c) ==1){
                    cvt.remove(c);
                }else {
                    cvt.put(c, cvt.get(c)-1);
                }
            }
        }

        return cvt.isEmpty();

        /*char[] ransomNoteCharArray = ransomNote.toCharArray(); // 双指针
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
        return left==ransomNoteCharArray.length;*/

    }

}
