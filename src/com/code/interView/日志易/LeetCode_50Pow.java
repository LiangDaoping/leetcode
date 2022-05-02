package com.code.interView.日志易;

/**
 * @description:
 * @author: gz
 * @date: 2022/03/22
 */
public class LeetCode_50Pow {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println(myPow(x, n)); // 1024.00000

        x = 2.10000;
        n = 3;
        System.out.println(myPow(x, n)); // 9.26100

        x = 2.00000;
        n = -2;
        System.out.println(myPow(x, n)); // 0.25000

        x = 2.00000;
        n = -2147483648;
        System.out.println(myPow(x, n)); // 0.0

    }

    public static double myPow1(double x, int n) {
        long pown = n;
        return pown >= 0 ? pow(x, pown) : 1.0 / pow(x, -pown);
    }

    public static double pow(double x, long n) {
        if (n == 0) return 1L;
        double y = pow(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    public static double myPow(double x, long n) {
        double ans = 1.0;
        long m = n < 0 ? 0 - n : n;
        while (m > 0) {
            if (m % 2 == 1) {
                ans *= x;
            }
            x *= x;
            m /= 2;
        }
        return n < 0 ? 1.0 / ans : ans;
    }
}
