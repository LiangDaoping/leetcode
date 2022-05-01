package com.code.leetcode.code1数组.螺旋矩阵II;

import java.util.Arrays;

public class LeetCode3_剑指Offer29顺时针打印矩阵 {
    public static void main(String[] args) {
        // 同LeetCode2_54螺旋矩阵
        // spiralOrder1：一层层的走
        // spiralOrder1：模拟转向
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(Arrays.toString(spiralOrder2(matrix))); // [1,2,3,6,9,8,7,4,5]

        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(Arrays.toString(spiralOrder2(matrix))); // [1,2,3,4,8,12,11,10,9,5,6,7]

        matrix = new int[][]{{1}};
        System.out.println(Arrays.toString(spiralOrder2(matrix))); // [1]

        matrix = new int[][]{{1, 2, 3, 4}, {8, 7, 6, 5}};
        System.out.println(Arrays.toString(spiralOrder2(matrix))); // [1,2,3,4,5,6,7,8]

        matrix = new int[][]{{1, 2}, {8,3}, {7,4}, {6, 5}};
        System.out.println(Arrays.toString(spiralOrder2(matrix))); // [1,2,3,4,5,6,7,8]

        matrix = new int[][]{{6,9,7}};
        System.out.println(Arrays.toString(spiralOrder2(matrix))); // [6,9,7]

    }

    public static int[] spiralOrder1(int[][] matrix) {
        int row = matrix.length;
        if (row <= 0) {
            return new int[0];
        }
        int column = matrix[0].length;
        int[] res = new int[row * column];
        int len = 0;

        int left = 0, right = column - 1;
        int top = 0, bottom = row - 1;
        while (left <= right && top <= bottom) {
            // 左上-右上,
            for (int i = left; i <= right; i++) {
                res[len++] = matrix[top][i];
            }
            // 右上-右下
            for (int i = top + 1; i <= bottom; i++) {
                res[len++] = matrix[i][right];
            }
            // 如果重叠，即left == right则不应该循环下半部分
            if (left < right && top < bottom) {
                //右下-左下
                for (int i = right - 1; i >= left + 1; i--) {
                    res[len++] = matrix[bottom][i];
                }
                //左下-左上
                for (int i = bottom; i >= top + 1; i--) {
                    res[len++] = matrix[i][left];
                }
            }

            left++;
            top++;
            right--;
            bottom--;
        }
        return res;
    }

    public static int[] spiralOrder2(int[][] matrix) {
        int row = matrix.length;
        if (row <= 0) {
            return new int[0];
        }
        int column = matrix[0].length;
        int[] res = new int[row * column];


        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        int dirIndex = 0;
        int rowIndex = 0, columnIndex = 0;
        boolean[][] visited = new boolean[row][column];
        for (int i = 0; i < res.length; i++) {
            res[i] = matrix[rowIndex][columnIndex];
            visited[rowIndex][columnIndex] = true;
            int nextRow = rowIndex + dir[dirIndex][0];
            int nextColumn = columnIndex + dir[dirIndex][1];
            if (nextRow < 0 || nextRow >= row || nextColumn < 0 || nextColumn >= column || visited[nextRow][nextColumn]) {
                dirIndex = (dirIndex + 1) % 4;
            }

            // 添加偏移量
            rowIndex += dir[dirIndex][0];
            columnIndex += dir[dirIndex][1];

        }

        return res;
    }




}
