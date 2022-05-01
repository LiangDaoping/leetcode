package com.code.leetcode.双周赛.第72场双周赛;


import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/22
 */
public class LeetCode1_5998拆分成最多数目的偶整数之和 {
    public static void main(String[] args) {
        int finalSum = 12;
        System.out.println(maximumEvenSplit(finalSum));//[2,4,6]

        finalSum = 28;
        System.out.println(maximumEvenSplit(finalSum));//[6,8,2,12]

        finalSum = 7;
        System.out.println(maximumEvenSplit(finalSum));//[]

        finalSum = 2;
        System.out.println(maximumEvenSplit(finalSum));//[]
    }

    public static List<Long> maximumEvenSplit1(long finalSum) {
        List<Long> ans = new ArrayList<>();
        if (finalSum % 2 != 0) {
            return ans;
        }

        long i = 2;
        long sum = 0;
        for (; i < finalSum; i += 2) {
            if (sum + i > finalSum) {
                break;
            }
            sum += i;
        }

        sum = 0;
        for (long j = 2; j < i - 2; j += 2) {
            sum += j;
            ans.add(j);
        }
        ans.add(finalSum - sum);
        return ans;
    }

    public static List<Long> maximumEvenSplit(long finalSum) {
        List<Long> ans = new ArrayList<>();
        // 如果finalSum是奇数，则一定不满足由偶整数组成的条件
        if (finalSum % 2 != 0) {
            return ans;
        }

        // 一个数由于正偶数组成，且不允许重复，要找最多的个数。
        // 这个组成结果一定是每个数小，数量多，因此是2 + 4 + 6 ...这样组成
        // 12 = 2 + 4 + 6
        // 14 = 2 + 4 + (6 + 2) = 2 + 4 + 8
        // 16 = 2 + 4 + (6 + 4) = 2 + 4 + 10
        // 18 = 2 + 4 + (6 + 6) = 2 + 4 + 12
        // 20 = 2 + 4 + 6 + 8

        long sum = 0;
        for (long i = 2; i <= finalSum; i += 2) {
            if (sum + i == finalSum) {
                ans.add(i);
                return ans;
            }
            if (sum + i > finalSum) {
                break;
            }
            sum += i;
            ans.add(i);
        }
        // 最后一个数字，需要补足
        Long lastNum = ans.get(ans.size() - 1);
        ans.set(ans.size() - 1, lastNum + finalSum - sum);
        return ans;
    }



}
