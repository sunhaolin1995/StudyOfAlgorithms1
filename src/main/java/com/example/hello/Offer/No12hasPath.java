package com.example.hello.Offer;

/**
 * @author 孙浩林
 * @date: 1/17/24 14:35
 */
public class No12hasPath {

    public static void main(String[] args) {
        char[][] matrix = {
                {'a', 'b', 'c', 'e'},
                {'s', 'f', 'c', 's'},
                {'a', 'd', 'e', 'e'}
        };
        String word = "abcced";
        System.out.println(hasPath(matrix, word));
    }

    public static boolean hasPath(char[][] matrix, String word) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (dfs(matrix, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] matrix, String word, int i, int j, int index) {
        //边界的判断，如果越界直接返回 false，index 表示的是查找到字符串 word 的第几个字符
        //如果这个字符不等于 matrix[i][j],说明验证这个坐标是走不通的，直接返回 false
        if (i >= matrix.length || i < 0 || j >= matrix[0].length || j < 0 || matrix[i][j] != word.charAt(index)) {
            return false;
        }
        //如果 word 的每个字符都查找完了，直接返回 true
        if (index == word.length() - 1) {
            return true;
        }
        //把当前坐标的值保存下来，为了在最后复原
        char tmp = matrix[i][j];
        //然后修改当前坐标的值
        matrix[i][j] = '.';
        //走递归，沿着当前坐标的上下左右 4 个方向查找
        boolean res = dfs(matrix, word, i, j, index + 1) || dfs(matrix, word, i - 1, j, index + 1)
                || dfs(matrix, word, i, j + 1, index + 1) || dfs(matrix, word, i, j - 1, index + 1);
        matrix[i][j] = tmp;
        return res;
    }


}
