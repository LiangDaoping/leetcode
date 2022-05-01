package com.code.leetcode.code1数组.长度最小的子数组;

public class LeetCode1_209长度最小的子数组 {
    public static void main(String[] args) {
        // minSubArrayLen1：暴力
        // minSubArrayLen2：暴力，优化
        // minSubArrayLen3：暴力，优化，优化
        // minSubArrayLen4：滑动窗口
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen4(target, nums)); // 2

        target = 4;
        nums = new int[]{1, 4, 4};
        System.out.println(minSubArrayLen4(target, nums));// 1

        target = 11;
        nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(minSubArrayLen4(target, nums));// 0

        target = 7;
        nums = new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen4(target, nums));// 2

        target = 15;
        nums = new int[]{1,2,3,4,5};
        System.out.println(minSubArrayLen4(target, nums));// 5


    }

    public static int minSubArrayLen1(int target, int[] nums) {
        int length = nums.length;
        int res = length + 1;
        for (int i = 0; i < length; i++) {
            int sum = 0;
            int min = 0;
            for (int j = i; j < length; j++) {
                if (sum >= target) {
                    break;
                }

                min++;
                sum += nums[j];
            }
            // 此处需要判断sum >= target 因为i=len-1时，j无法因为满足sum>=target而跳出循环
            if (sum >= target && res > min) {
                res = min;
            }
        }
        return res == length + 1 ? 0 : res;
    }

    public static int minSubArrayLen2(int target, int[] nums) {
        int length = nums.length;
        int res = length + 1;
        for (int i = 0; i < length; i++) {
            int sum = 0;
            int j = i;
            for (; j < length; j++) {
                if (sum >= target) {
                    break;
                }
                sum += nums[j];
            }
            int subRes = j - i;
            if (sum >= target && res > subRes) {
                res = subRes;
            }
        }
        return res == length + 1 ? 0 : res;
    }

    public static int minSubArrayLen3(int target, int[] nums) {
        int length = nums.length;
        int res = length + 1;
        for (int i = 0; i < length; i++) {
            int sum = 0;
            int j = i;
            for (; j < length; j++) {
                // 放上面是为了，第i哥位置的数字就比较是否为target，而不是白白比较一次sum
                sum += nums[j];
                if (sum >= target) {
                    int subRes = j - i + 1;
                    if (res > subRes) {
                        res = subRes;
                    }
                    break;
                }

            }
        }
        return res == length + 1 ? 0 : res;
    }

    public static int minSubArrayLen4(int target, int[] nums) {
        // 时间复杂度O(n)：再循环中每次都是后面index加1，前面index减1，每次操作的是2*n，且是同向操作
        // 空间复杂度O(1)
        int begin = 0;
        int res = nums.length + 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 此处一直在加数量
            sum += nums[i];
            while (sum >= target) {
                int subLen = i - begin + 1;
                if (res > subLen) res = subLen;
                // 与上面对应，上面加，这里从前往后减
                sum -= nums[begin];
                begin++;
            }
        }

        return res == nums.length + 1 ? 0 : res;
    }
}
