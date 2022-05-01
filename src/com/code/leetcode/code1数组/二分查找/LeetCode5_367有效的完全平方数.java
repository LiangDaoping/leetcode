package com.code.leetcode.code1数组.二分查找;

/**
 * @description:
 * @author: gz
 * @date: 2021/12/26
 */
public class LeetCode5_367有效的完全平方数 {
    public static void main(String[] args) {
        // isPerfectSquare1：二分
        // isPerfectSquare2：牛顿迭代法
        int num = 16;
        System.out.println(isPerfectSquare2(num)); // true

        num = 14;
        System.out.println(isPerfectSquare2(num)); // false

        num = 2147483647;
        System.out.println(isPerfectSquare2(num)); // false
    }

    public static boolean isPerfectSquare1(int num) {
        int low = 0;
        int high = num;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long square = (long)mid * mid;
            if (square < num) {
                low = mid + 1;
            } else if (square > num) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean isPerfectSquare2(int num) {
        double C = num;
        double x0 = num;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        x0 = (int) x0;
        return x0 * x0 == num;
    }




}
