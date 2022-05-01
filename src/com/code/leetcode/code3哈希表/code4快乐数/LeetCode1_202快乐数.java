package com.code.leetcode.code3哈希表.code4快乐数;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description:
 * @author: gz
 * @date: 2022/01/23
 */
public class LeetCode1_202快乐数 {
    public static void main(String[] args) {
        //isHappy1:自写，递归
        //isHappy2：题解递归
        //isHappy3：题解,快慢指针
        int n = 19;
        System.out.println(isHappy3(n));

        n = 2;
        System.out.println(isHappy3(n));
    }

    public static boolean isHappy1(int n) {
        Set<Integer> integers = new HashSet<>();
        return isHappy1(integers, n);
    }

    public static boolean isHappy1(Set<Integer> set, int n) {
        if (set.contains(n)) return false;
        set.add(n);

        List<Integer> list = new ArrayList<>();
        while (n >= 10) {
            list.add(n % 10);
            n = n / 10;
        }
        list.add(n % 10);

        int total = 0;
        for (Integer integer : list) {
            total += integer * integer;
        }
        if (total == 1) return true;
        return isHappy1(set, total);
    }

    public static boolean isHappy2(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public static int getNext(int n) {
        int total = 0;
        while (n > 0) {
            int i = n % 10;
            total += i * i;
            n = n / 10;
        }
        return total;
    }

    public static boolean isHappy3(int n) {
        int slow = n;
        int fast = getNext(n);
        while (n != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }
}
