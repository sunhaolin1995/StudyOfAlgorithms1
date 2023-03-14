package com.example.hello.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class No36isValidSudoKu {

    public boolean isValidSudoku(char[][] board) {

        for (int k = 1; k <=3 ; k++) {
            HashSet<Character> smallConvert = new HashSet<>();
            for (int i = 0+3*k; i <3*k; i++) {
                for (int j = 0; j <3*k ; j++) {
                    if (!smallConvert.add(board[i][j])){
                        return false;
                    }
                }
            }
        }
        for (int i = 0; i < ; i++) {
            
        }
        
        return true;
    }
    
    
}
