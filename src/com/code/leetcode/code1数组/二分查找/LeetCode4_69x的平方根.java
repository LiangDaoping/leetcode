package com.code.leetcode.code1数组.二分查找;

/**
 * @description:
 * @author: gz
 * @date: 2021/12/26
 */
public class LeetCode4_69x的平方根 {
    public static void main(String[] args) {
        // 小于数x，最大的二次方，
        // mySqrt1：暴力
        // mySqrt2：二分
        // mySqrt3：抄的题解，袖珍计算器算法√x=x^(1/2) = (e^(Inx))^(1/2)=e^(1/2*Inx)
        // mySqrt4：抄的题解，牛顿迭代法
        System.out.println(mySqrt4(4)); // 2
        System.out.println(mySqrt4(8)); // 2
        System.out.println(mySqrt4(2147483647)); // 46340

    }

    public static int mySqrt1(int x) {
        int max = 0x7fffffff; // 2^31 - 1
        for (int i = 0; i <  max; i++) {
            // 此处i*i可能会超出
            if ((long)i * i > x) {
                return i - 1;
            }
            if (i * i == x) {
                return i;
            }
        }
        return 0;
    }

    public static int mySqrt2(int x) {
        int low = 0;
        int high = x;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long l = (long) mid * mid;
            if (l < x) {
                low = mid + 1;
            } else if (l > x) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return low - 1;
    }

    public static int mySqrt3(int x) {
        if (x == 0) return 0;
        int exp = (int) Math.exp(0.5 * Math.log(x));
        // 由于double类型存在精度损失，可能因为很小的10^(-11)的误差，导致答案错误
        return (long)(exp + 1) * (exp + 1) <= x ? exp + 1: exp;
    }

    public static int mySqrt4(int x) {
        if (x == 0) return 0;
        double C = x;
        double x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }


}
