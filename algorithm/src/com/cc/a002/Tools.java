package com.cc.a002;

/**
 * @author qinchuanchuan
 */
public class Tools {
    private Tools() {
    }

    public static ListNode NumberToList(int number) {
        // 处理负数，确保数字大于等于0
        if (number < 0) {
            System.out.println("请确保数字大于等于0");
            return null;
        }
        // 处理数字为0的情况，直接返回一个包含0的链表节点
        if (number == 0) {
            return new ListNode(0);
        }
        // 处理数字大于0的情况，逐位创建链表节点
        ListNode head = null; // 链表头节点
        ListNode tail = null; // 链表尾节点
        while (number > 0) {
            // 获取当前数字的最后一位
            int digit = number % 10;
            // 创建一个新节点，存储当前数字的最后一位
            ListNode node = new ListNode(digit);
            // 如果是第一个节点，则设置头节点和尾节点
            if (head == null) {
                head = node;
                tail = node;
            } else { // 否则，将节点添加到链表尾部
                tail.next = node;
                tail = node;
            }
            // 去掉当前数字的最后一位
            number /= 10;
        }
        return head;
    }
}
