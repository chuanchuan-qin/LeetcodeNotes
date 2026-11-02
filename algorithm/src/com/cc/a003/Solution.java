package com.cc.a003;

import java.util.HashSet;

/**
 * @author qinchuanchuan
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录当前窗口中的字符
        HashSet<Character> hashSet = new HashSet<>();
        // 获取字符串的长度
        int length = s.length();
        // 记录窗口的边界，left为左边界
        int left = 0;
        // 记录最长子串的长度
        int maxLength = 0;
        // 遍历字符串时的i为右边界
        for (int right = 0; right < length; right++) {
            // 判断是否与窗口中的字符重复
            while (hashSet.contains(s.charAt(right))) {
                // 如果重复，则左边界向右移动，直到不重复
                hashSet.remove(s.charAt(left));
                left++;
            }
            // 此时窗口中不包含重复字符，加入窗口
            hashSet.add(s.charAt(right));
            // 更新最长子串的长度
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
