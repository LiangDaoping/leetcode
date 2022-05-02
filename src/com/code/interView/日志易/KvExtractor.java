package com.code.interView.日志易;

import java.util.*;

/**
 * @description:
 * @author: gz
 * @date: 2022/03/17
 */
public class KvExtractor {
    public static void main(String[] args) {
        String inputString = "k1=v1;k2=v2;k3=v3;k4=\"v41=v42\"";
        Map<String, String> extract = extract(inputString);
        printMap(extract);

        inputString = "k1=v1;k2=v2;k3=v3;k4=\"k5=v5\"";
        extract = extract(inputString);
        printMap(extract);

        inputString = "k1=;k2=v2;k3=v3;k4=\"k5=v5\"";
        extract = extract(inputString);
        printMap(extract);

        inputString = "v2;k3=v3;k4=\"k5=v5\"";
        extract = extract(inputString);
        printMap(extract);

        inputString = "v2;k3=v3;k4=\"k5=v5;k6=v6\"";
        extract = extract(inputString);
        printMap(extract);

        inputString = "v2;k3=v3;k4=\"\\\"k5=v5\\\";k6=v6\"";
        extract = extract(inputString);
        printMap(extract);
    }

    /**
     * inputString: k1=v1;k2=v2;k3=v3;k4=v41,v42
     * 输出的Map有四个kv键值对（->之前为key，之后为value）
     * outputString: Map<k1->v1, k2->v2, k3->v3, k4->v41,v42>
     * @param inputString 字符串
     * @return 格式化的map对象
     */
    public static Map<String, String> extract(String inputString) {
        Map<String, String> ans = new HashMap<>();
        if (inputString == null || inputString.isEmpty()) return ans;
        // 每个map是根据分号作为结束符号，末尾添加分号，方便操作。
        String s = inputString + ";";
        // 标记位，是否可以进行拆分
        boolean splitFlag = true;
        String key = "";
        int begin = 0;
        for (int end = 0; end < s.length(); end++) {
            char charAt = s.charAt(end);
            if (splitFlag) {
                // 当可以进行拆分时，拆分对应的key-value
                if (charAt == '=') {
                    key = s.substring(begin, end);
                    begin = end + 1;
                }
                if (charAt == ';') {
                    String value = s.substring(begin, end);
                    if (s.charAt(begin) == '"' && s.charAt(end - 1) == '"') {
                        value = s.substring(begin + 1, end - 1);
                    }
                    if (!"".equals(key) && !"".equals(value)) {
                        ans.put(key, value);
                    }
                    begin = end + 1;
                }
            }
            // 碰到双引号后，则反转标记位。且该双引号不是转义的双引号
            boolean b = end > 0 && s.charAt(end - 1) != '\\';
            if (charAt == '"' && b) {
                splitFlag = !splitFlag;
            }
        }
        return ans;
    }

    public static void printMap(Map<String, String> map) {
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            System.out.println("<" + stringStringEntry.getKey() + "," + stringStringEntry.getValue() + ">");
        }
        System.out.println("-------------------------------------");
    }
}
