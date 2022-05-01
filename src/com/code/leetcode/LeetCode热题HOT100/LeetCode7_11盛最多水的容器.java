package com.code.leetcode.LeetCode热题HOT100;


/**
 * @description:
 * @author: gz
 * @date: 2022/03/14
 */
public class LeetCode7_11盛最多水的容器 {
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        // （8-1）*7=49
        System.out.println(maxArea(height)); // 49

        height = new int[]{1,1};
        System.out.println(maxArea(height)); // 1
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }

}
