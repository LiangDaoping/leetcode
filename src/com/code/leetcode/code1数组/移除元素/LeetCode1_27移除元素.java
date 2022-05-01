package com.code.leetcode.code1数组.移除元素;

/**
 * @description:
 * @author: gz
 * @date: 2021/12/26
 */
public class LeetCode1_27移除元素 {
    public static void main(String[] args) {
        // removeElement1 暴力
        // removeElement2 暴力优化
        // removeElement3 暴力优化
        // removeElement4 双指针法
        // removeElement5 双指针法优化
        int[] nums = {3,2,2,3};
        int val = 3;
        execute(nums, val); // 2 [2,2]

        nums = new int[]{0,1,2,2,3,0,4,2};
        val = 2;
        execute(nums, val); // 5 [0,1,3,0,4]

        nums = new int[]{4,5};
        val = 4;
        execute(nums, val); // 1 [5]

    }

    public static void execute(int[] nums, int val) {
        int len = removeElement5(nums, val);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static int removeElement1(int[] nums, int val) {
        int size = nums.length;
        int count = 0;
        for (int i = 0; i < size - count; i++) {
            if (nums[i] == val) {
                for (int j = i; j < size - count - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                // 当发现重复，移位后，当前节点还需要检测，因此i--
                i--;
                count++;
            }
        }
        return size - count;
    }

    public static int removeElement2(int[] nums, int val) {
        int size = nums.length;
        int count = 0;
        for (int i = 0; i < size - count; i++) {
            if (nums[i] == val) {
                System.arraycopy(nums, i + 1, nums, i, size - count - i - 1);
                // 当发现重复，移位后，当前节点还需要检测，因此i--
                i--;
                count++;
            }
        }
        return size - count;
    }

    public static int removeElement3(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == val) {
                System.arraycopy(nums, i + 1, nums, i, size - i - 1);
                // 当发现重复，移位后，当前节点还需要检测，因此i--
                i--;
                size--;
            }
        }
        return size;
    }

    public static int removeElement4(int[] nums, int val) {
        int size = nums.length;
        int slow = 0;
        int fast = 0;
        for (int i = 0; i < size; i++) {
            if (nums[i] == val) {
                fast++;
            } else {
                nums[slow++] = nums[fast++];
            }
        }
        return slow;
    }

    public static int removeElement5(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }




}
