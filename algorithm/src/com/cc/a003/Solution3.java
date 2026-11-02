package com.cc.a003;

/**
 * @author qinchuanchuan
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        // 定义一个数组来记录字符的索引
        int[] charIndex = new int[128];
        // 记录当前无重复字符的子串的长度
        int maxLength = 0;
        // 记录窗口的左边界left
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            // 如果字符在当前子字符串中，则更新左边界
            if (charIndex[c] >= left) {
                left = charIndex[c];
            }
            // 更新字符的索引
            charIndex[c] = right + 1;
            // 更新当前无重复字符的子串的长度
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
