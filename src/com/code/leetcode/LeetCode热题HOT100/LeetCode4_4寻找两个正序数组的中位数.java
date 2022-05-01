package com.code.leetcode.LeetCode热题HOT100;

/**
 * @description:
 * @author: gz
 * @date: 2022/03/14
 */
public class LeetCode4_4寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums1, nums2)); // 2.00000

        nums1 = new int[] {1, 2};
        nums2 = new int[] {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2)); // 2.50000

        nums1 = new int[] {1, 3, 4, 9};
        nums2 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(findMedianSortedArrays(nums1, nums2)); // 4
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            // 奇数：（nums1 + nums2）/ 2 + 1
            double median = getKthElement(nums1, nums2, totalLength / 2 + 1);
            return median;
        } else {
            // 偶数：（nums1 + nums2）/ 2、（nums1 + nums2）/ 2 + 1
            double kthElement1 = getKthElement(nums1, nums2, totalLength / 2);
            double kthElement2 = getKthElement(nums1, nums2, totalLength / 2 + 1);
            double median = (kthElement1 + kthElement2) / 2.0;
            return median;
        }
    }

    public static int getKthElement(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        int index1 = 0;
        int index2 = 0;
        while (true) {
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;

            if (nums1[newIndex1] <= nums2[newIndex2]) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }

        }
    }



}
