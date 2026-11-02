package com.cc.a001;

import java.util.HashMap;

/**
 * @author qinchuanchuan
 */
public class Solution2 {
    public static int[] twoSum(int[] nums, int target) {
        // 创建一个哈希表，用于存储数组元素和其对应的下标
        HashMap<Integer, Integer> map = new HashMap<>();
        // 遍历数组，i为当前元素的下标
        for (int i = 0; i < nums.length; i++) {
            // 判断哈希表中是否存在目标值与当前元素的差
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            // 如果不存在，则将当前元素和其下标存入哈希表
            map.put(nums[i], i);
        }
        // 如果没有找到，则返回空数组
        return new int[]{};
    }
}
