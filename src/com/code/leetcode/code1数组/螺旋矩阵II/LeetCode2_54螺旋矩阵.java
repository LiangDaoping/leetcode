package com.code.leetcode.code1数组.螺旋矩阵II;

import java.util.ArrayList;
import java.util.List;

public class LeetCode2_54螺旋矩阵 {
    public static void main(String[] args) {
        // spiralOrder1：炒题解+自写，一层层的添加
        // spiralOrder2：看题解后自写，转向方法
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(spiralOrder1(matrix)); // [1,2,3,6,9,8,7,4,5]

        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder1(matrix)); // [1,2,3,4,8,12,11,10,9,5,6,7]

        matrix = new int[][]{{1}};
        System.out.println(spiralOrder1(matrix)); // [1]

        matrix = new int[][]{{1, 2, 3, 4}, {8, 7, 6, 5}};
        System.out.println(spiralOrder1(matrix)); // [1,2,3,4,5,6,7,8]

        matrix = new int[][]{{1, 2}, {8,3}, {7,4}, {6, 5}};
        System.out.println(spiralOrder1(matrix)); // [1,2,3,4,5,6,7,8]

        matrix = new int[][]{{6,9,7}};
        System.out.println(spiralOrder1(matrix)); // [6,9,7]

    }

    public static List<Integer> spiralOrder1(int[][] matrix) {
        // 行
        int m = matrix.length;
        // 列
        int n = matrix[0].length;

        // [top, bottom],[left, right]
        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;
        List<Integer> res = new ArrayList<>();
        while (left <= right && top <= bottom) {
            // 左上-右上
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            // 右上-右下
            for (int i = top + 1; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            if (left < right && top < bottom) {
                // 右下-左下
                for (int i = right - 1; i >= left + 1; i--) {
                    res.add(matrix[bottom][i]);
                }
                // 左下-左上
                for (int i = bottom; i >= top + 1; i--) {
                    res.add(matrix[i][left]);
                }
            }
            left++;
            top++;

            right--;
            bottom--;
        }
        return res;
    }

    public static List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        // 行
        int m = matrix.length;
        // 列
        int n = matrix[0].length;


        int[] rowDirections = {0, 1, 0, -1};
        int[] columnDirections = {1, 0, -1, 0};
        int rowIndex = 0;
        int columnIndex = 0;

        int total = m * n;
        int row = 0, column = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < total; i++) {
            res.add(matrix[row][column]);
            visited[row][column] = true;
            // 到达边界后，转向
            int nextRow = row + rowDirections[rowIndex];
            int nextColumn = column + columnDirections[columnIndex];
            if (nextRow < 0 || nextColumn < 0 || nextRow >= m || nextColumn >= n || visited[nextRow][nextColumn]) {
                rowIndex = (rowIndex + 1) % 4;
                columnIndex = (columnIndex + 1) % 4;
            }
            row += rowDirections[rowIndex];
            column += columnDirections[columnIndex];
        }

        return res;
    }




}
