package com.cc.a001;

/**
 * @author qinchuanchuan
 */
public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        // 外部循环：遍历数组每一个元素
        for (int i = 0; i < nums.length; i++) {
            // 内部循环：从外层循环的下一个元素开始遍历
            for (int j = i + 1; j < nums.length; j++) {
                // 判断两数之和是否等于目标值target
                if (nums[i] + nums[j] == target) {
                    // 返回结果
                    return new int[]{i, j};
                }
            }
        }
        // 如果没有找到，则返回空数组
        return new int[]{};
    }
}
