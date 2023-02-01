package com.example.hello.leetcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class No2325DecodeMessage {

    public static void main(String[] args) {
        String  key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv";
        System.out.println(decodeMessage(key,message));
    }

    public static String decodeMessage(String key, String message) {

        HashMap<Character,Character> result = new HashMap<>();

        char current = 'a';

        for (int i = 0; i <key.length() ; i++) {
            if (key.charAt(i) != ' ' && !result.containsKey(key.charAt(i))){
                result.put(key.charAt(i),current);
                current++;
            }
        }

        StringBuilder returnResult = new StringBuilder();

        for (int i = 0; i <message.length() ; i++) {
            Character resultChar = new Character(' ');
            if (message.charAt(i)!=' '){
               resultChar = result.get(message.charAt(i));
            }
            returnResult.append(resultChar);

        }

        return returnResult.toString();
    }

}
