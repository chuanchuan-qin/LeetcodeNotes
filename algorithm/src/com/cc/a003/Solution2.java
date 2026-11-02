package com.cc.a003;

import java.util.HashMap;

/**
 * @author qinchuanchuan
 */
public class Solution2 {
    public int lengthOfLongestSubstring(String s) {
        // 定义hashmap记录字符和对应的索引
        HashMap<Character, Integer> hashMap = new HashMap<>();
        // 字符串的长度
        int length = s.length();
        // 记录当前无重复字符的子串的长度
        int maxLength = 0;
        // 记录窗口的左边界left
        int left = 0;
        // 遍历字符串
        for (int right = 0; right < length; right++) {
            char c = s.charAt(right);
            // 如果字符在hashmap中存在，则更新左边界
            if (hashMap.containsKey(c)) {
                // 更新左边界为重复字符的下一个位置和当前左边界中的较大值
                left = Math.max(left, hashMap.get(c) + 1);
            }
            // 将字符和对应的索引存入hashmap
            hashMap.put(c, right);
            // 更新当前无重复字符的子串的长度
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
