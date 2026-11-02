package com.cc.a003;

/**
 * @author qinchuanchuan
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        // 定义一个数组来记录字符的索引
        int[] charIndex = new int[128];

        int maxLength = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果字符在当前子字符串中，则更新左边界
            if (charIndex[c] >= left) {
                left = charIndex[c];
            }
            charIndex[c] = i + 1;
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }
}
