package com.code.leetcode.周赛.第288场周赛;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/23
 */
public class LeetCode1_6037按奇偶性交换后的最大数字 {
    public static void main(String[] args) {
        int num = 1234;
        System.out.println(largestInteger(num)); // 3412

        num = 65875;
        System.out.println(largestInteger(num)); // 87655
    }

    public static int largestInteger(int num) {
        // 奇数正序排序，偶数正序排序
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            list.add(num % 10);
            num = num / 10;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int min = list.get(i);
            int index = i;
            // 奇偶性：偶数为true，奇数为false
            boolean nature = min % 2 == 0;
            for (int j = i + 1; j < size; j++) {
                Integer integer = list.get(j);
                boolean tempNature = integer % 2 == 0;
                if (nature == tempNature && integer < min) {
                    min = integer;
                    index = j;
                }
            }
            list.set(index, list.get(i));
            list.set(i, min);
        }
        int ans = 0;
        int carry = 1;
        for (int i = 0; i < list.size(); i++) {
            ans += carry * list.get(i);
            carry *= 10;
        }
        return ans;
    }
}
