package com.code.leetcode.双周赛.第70场双周赛;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/22
 */
public class LeetCode2_5972统计隐藏数组数目 {
    public static void main(String[] args) {
        //https://leetcode-cn.com/problems/count-the-hidden-sequences/
        //https://leetcode-cn.com/contest/biweekly-contest-70/ranking/1/
        int[] differences = new int[]{1,-3,4};
        int lower = 1, upper = 6;
        System.out.println(numberOfArrays2(differences, lower, upper));//2


        differences = new int[]{3,-4,5,1,-2};
        lower = -4; upper = 5;
        System.out.println(numberOfArrays2(differences, lower, upper));//4

        differences = new int[]{4,-7,2};
        lower = 3; upper = 6;
        System.out.println(numberOfArrays2(differences, lower, upper));//0

        differences = new int[]{-40};
        lower = -46; upper = 53;
        System.out.println(numberOfArrays2(differences, lower, upper));//60

        differences = new int[]{-11054,-29384,-79640};
        lower = 21923; upper = 53016;
        System.out.println(numberOfArrays2(differences, lower, upper));//60

        differences = new int[50000];
        for (int i = 0; i < 50000; i++) {
            differences[i] = 1000000;
        }
        lower = 100000; upper = 100000;
        System.out.println(numberOfArrays2(differences, lower, upper));//60
    }

    public static int numberOfArrays1(int[] differences, int lower, int upper) {
        int total = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int difference : differences) {
            total += difference;
            if (max < total) max = total;
            if (min > total) min = total;
        }

        int ans = 0;
        for(int i = lower; i <= upper; ++i) {
            if((i + max) <= upper && (i + min) >= lower) {
                ans++;
            }
        }
        return ans;
    }

    public static int numberOfArrays2(int[] differences, int lower, int upper) {
        long total = 0;
        long max = 0;
        long min = 0;
        for (int difference : differences) {
            total += difference;
            if (max < total) max = total;
            if (min > total) min = total;
        }
        int grap = (int) (max - min);
        if (grap > upper - lower) return 0;
        return upper - lower - grap + 1;

//        long long mn = 0, mx = 0, now = 0;
//        for (int x : differences) {
//            now += x;
//            mn = min(mn, now);
//            mx = max(mx, now);
//        }
//        if (mx - mn > upper - lower) return 0;
//        return (upper - lower) - (mx - mn) + 1;
    }


}
