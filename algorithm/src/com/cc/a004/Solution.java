package com.cc.a004;

/**
 * @author qinchuanchuan
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 获取两个数组的长度
        int length1 = nums1.length;
        int length2 = nums2.length;
        // 总长度
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            // 奇数情况，中位数为第 totalLength / 2 + 1 个元素
            return getKthElement(nums1, 0, nums2, 0, totalLength / 2 + 1);
        } else {    // 偶数情况，中位数为第 totalLength / 2 + 1 个元素和第 totalLength / 2 + 1 个元素的平均值
            return (getKthElement(nums1, 0, nums2, 0, totalLength / 2) +
                    getKthElement(nums1, 0, nums2, 0, totalLength / 2 + 1)) / 2.0;
        }
    }

    public int getKthElement(int[] nums1, int start1, int[] nums2, int start2, int k) {
        // 首先判断边缘，如果起始索引超出了数组边界，则在另一个数组取第 k 大的元素
        if (start1 >= nums1.length) {
            return nums2[start2 + k - 1];
        }
        if (start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        }
        // 如果 k 等于 1，返回两数组其实元素的较小值
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        // 分别在两数组从起始索引开始查找第 k / 2 大的元素
        int half = k / 2;

        // 计算出第 k / 2 大元素的索引，如果超出数组边界则取数组最后一个元素
        int index1 = Math.min(start1 + half - 1, nums1.length - 1);
        int index2 = Math.min(start2 + half - 1, nums2.length - 1);

        // 分别计算出两个数组从起始元素到上面计算出索引的个数
        int count1 = index1 - start1 + 1;
        int count2 = index2 - start2 + 1;

        // 排除较小元素前面的元素，重新查找值
        if (nums1[index1] < nums2[index2]) {
            return getKthElement(nums1, index1 + 1, nums2, start2, k - count1);
        } else {
            return getKthElement(nums1, start1, nums2, index2 + 1, k - count2);
        }
    }
}
