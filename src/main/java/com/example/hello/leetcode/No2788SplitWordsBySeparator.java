package com.example.hello.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class No2788SplitWordsBySeparator {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("one.two.three");
        words.add("four.five");
        words.add("six");
        char separator = '.';
        List<String> strings = splitWordsBySeparator(words, separator);
        for (int i = 0; i < strings.size() ; i++) {
            System.out.println(strings.get(i));
        }
    }

    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        return words.stream()
                .flatMap(word -> Arrays.stream(word.split(Pattern.quote(String.valueOf(separator)))))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.toList());
    }


}
