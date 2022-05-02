package com.code.interView.源码解析;

/**
 * @description:
 * @author: gz
 * @date: 2022/03/29
 */
public class String的indexOf源码 {

    public static void main(String[] args) {
        String a = "aa";
        String b = "aaa";

        System.out.println(a.indexOf(b, -1));

        int index = indexOf(a.toCharArray(), 0, a.toCharArray().length,
                b.toCharArray(), b.toCharArray().length + 2, b.toCharArray().length, 0);
        System.out.println(index);
    }


    /**
     *
     * @param source 源数据
     * @param sourceOffset 源数据偏移位置
     * @param sourceCount 源数据的长度
     * @param target 目标数据
     * @param targetOffset 目标数据偏移位置
     * @param targetCount 目标数据的长度
     * @param fromIndex 开始位置
     * @return
     */
    static int indexOf(char[] source, int sourceOffset, int sourceCount,
                       char[] target, int targetOffset, int targetCount,
                       int fromIndex) {
        // 如果寻找的开始位置大于源数据的总长度
        if (fromIndex >= sourceCount) {
            // 如果目标总长度为0，且寻找的开始位置在sourceCount～无穷之间，那么就是sourceCount位置
            // 否则是-1，即未找到
            return (targetCount == 0 ? sourceCount : -1);
        }
        // 如果存在非法的开始下标，那么为0
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        // 如果目标总长度为0，且寻找的开始位置在0～sourceCount之间，从fromIndex开始，那么就是fromIndex位置
        if (targetCount == 0) {
            return fromIndex;
        }

        // 目标数据的第一个开始的元素
        char first = target[targetOffset];
        // 开始下标：源数据偏移位置 + 开始位置
        // 开始下标：源数据偏移位置 + （源数据的总长度 - 目标数据的总长度）
        int max = sourceOffset + (sourceCount - targetCount);

        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            // 如果当前源数据都不等于目标数据，则寻找到第一个源数据的开始字母等于目标数据的开始字母的地方
            if (source[i] != first) {
                while (++i <= max && source[i] != first);
            }

            // 当找到第一个相等的元素后，开始最查找后面是否相同
            if (i <= max) {
                // j：源数据的下标，源数据的下标i已经是相等的，因此j从i+1开始到j+targetCount-1结束
                // k：目标数据的下标，目标数据的下标targetOffset已经是相等的，从targetOffset+1开始到源数据和目标数据不等为止
                int j = i + 1;
                int end = j + targetCount - 1;
                // 为什么不会越界？
                // k的下标是从targetOffse+1开始，到k的结束。仅当targetOffset > targetCount时会越界，但无该情况的调用
                // j的下标是从i + 1到i+targetCount，但是i最大是sourceOffset + (sourceCount - targetCount)，因此j最大sourceOffset+sourceCount不会越界
                for (int k = targetOffset + 1; j < end && source[j]
                        == target[k]; j++, k++);

                if (j == end) {
                    // 当全部字母符合后，则返回下标
                    return i - sourceOffset;
                }
            }
        }
        // 如果源数据的总长度 < 目标数据的总长度，则结果是-1
        return -1;
    }
}
