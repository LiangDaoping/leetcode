package com.code.leetcode.code1数组.螺旋矩阵II;

import java.util.Arrays;

public class LeetCode1_59螺旋矩阵II {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(Arrays.deepToString(generateMatrix1(n))); // [[1,2,3],[8,9,4],[7,6,5]]

        n = 1;
        System.out.println(Arrays.deepToString(generateMatrix1(n))); // [[1]]

        n = 4;
        System.out.println(Arrays.deepToString(generateMatrix1(n))); // [[1, 2, 3, 4], [12, 13, 14, 5], [11, 16, 15, 6], [10, 9, 8, 7]]

        n = 5;
        System.out.println(Arrays.deepToString(generateMatrix1(n))); // [[1,2,3,4,5],[16,17,18,19,6],[15,24,25,20,7],[14,23,22,21,8],[13,12,11,10,9]]

    }

    public static int[][] generateMatrix1(int n) {
        int num = 1;
        int[][] res = new int[n][n];

        int add = 0;


        while (n > 0) {
            if (n == 1) {
                res[add][add] = num;
                break;
            }
            int count = n - 1;
            for (int i = 0; i < count; i++) {
                res[add][add + i] = num++;
            }
            for (int i = 0; i < count; i++) {
                res[add + i][count + add] = num++;
            }
            for (int i = count; i > 0; i--) {
                res[count + add][add + i] = num++;
            }
            for (int i = count; i > 0; i--) {
                res[add + i][add] = num++;
            }
            if (n == 2) {
                break;
            }

            n -= 2;
            add++;

        }
        return res;
    }


}
