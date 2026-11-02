package com.cc.a002;

/**
 * @author qinchuanchuan
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 创建求和后的链表头节点
        ListNode head = null;
        // 创建求和后的链表尾节点
        ListNode tail = null;
        // 创建进位值，初始为0
        int carry = 0;
        while (l1 != null || l2 != null) {
            // 取出两个链表当前节点的值，如果节点为空则取0
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            // 求和并加上进位值
            int sum = n1 + n2 + carry;
            // 计算进位值
            carry = sum / 10;
            // 创建新的节点，存储求和后的值
            ListNode node = new ListNode(sum % 10);
            // 如果是第一个节点，则设置头节点和尾节点
            if (head == null) {
                head = node;
                tail = node;
            } else { // 否则，将节点添加到链表尾部
                tail.next = node;
                tail = node;
            }
            // 移动到下一个节点
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        // 如果最后还有进位值，则创建一个新的节点存储进位值
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
