package com.example.hello.leetcode;

/**
 * @author 孙浩林
 * @date: 4/23/23 16:49
 */
public class No1105MinHeightShelves {

    public static void main(String[] args) {
        int[][] books = {{9, 9}, {5, 4}, {3, 1}, {1, 5}, {7, 3}};
        int shelfWidth = 10;
        System.out.println(minHeightShelves(books, shelfWidth));
    }

    public static int[][] book;
    public static int shelfWidth1;

    public static int minHeightShelves(int[][] books, int shelfWidth) {
        book = books;
        shelfWidth1 = shelfWidth;
        return dfs(books.length - 1);
    }

    public static int dfs(int i) {
        if (i < 0) return 0; // 没有书了，高度是 0
        int res = Integer.MAX_VALUE, maxH = 0, leftW = shelfWidth1;
        for (int j = i; j >= 0; --j) {
            leftW -= book[j][0];
            if (leftW < 0) break; // 空间不足，无法放书
            maxH = Math.max(maxH, book[j][1]); // 从 j 到 i 的最大高度
            res = Math.min(res, dfs(j - 1) + maxH);
        }
        return res;
    }


}
