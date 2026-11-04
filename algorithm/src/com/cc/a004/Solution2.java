package com.cc.a004;

/**
 * @author qinchuanchuan
 */
public class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 获取两个数组的长度
        int length1 = nums1.length;
        int length2 = nums2.length;
        // 总长度
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            // 奇数情况，中位数为第 totalLength / 2 + 1 个元素
            return getKthElement(nums1, nums2, totalLength / 2 + 1);
        } else {    // 偶数情况，中位数为第 totalLength / 2 + 1 个元素和第 totalLength / 2 + 1 个元素的平均值
            return (getKthElement(nums1, nums2, totalLength / 2) +
                    getKthElement(nums1, nums2, totalLength / 2 + 1)) / 2.0;
        }
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        // 记录两数组的长度
        int length1 = nums1.length;
        int length2 = nums2.length;
        // 记录总长度
        int totalLength = length1 + length2;
        // 记录起始索引
        int start1 = 0, start2 = 0;

        while (true) {
            int half = k / 2;
            // 边界处理
            if (start1 >= length1) {
                return nums2[start2 + k - 1];
            }
            if (start2 >= length2) {
                return nums1[start1 + k - 1];
            }
            if (k==1) {
                return Math.min(nums1[start1], nums2[start2]);
            }
            // 两数组中第 half 元素的索引
            int index1 = Math.min(start1 + half - 1, nums1.length - 1);
            int index2 = Math.min(start2 + half - 1, nums2.length - 1);

            int pivot1 = nums1[index1], pivot2 = nums2[index2];

            if (pivot1 < pivot2) {
                k -= index1 - start1 + 1;
                start1 = index1 + 1;
            } else {
                k -= index2 - start2 + 1;
                start2 = index2 + 1;
            }

        }
    }
}
