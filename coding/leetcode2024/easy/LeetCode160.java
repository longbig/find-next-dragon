package leetcode2024.easy;

import leetcode2021.compitetion.ListNode;

/**
 * @author yuyunlong
 * @date 2024/8/6 00:05
 * @description 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表不存在相交节点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 */
public class LeetCode160 {

    /**
     * 思路：快慢指针，两个指针同时遍历，
     * 如果一个指针到结尾了，另一个指针没到末尾。那么指针A从链表B的开头开始遍历，指针B还是从已走过的A链表长度位置开始
     * 等到指针B走到末尾时，指针A走了两链表相差的长度，紧接着同时遍历，并判断结点是否一样即可
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tempA = headA, tempB = headB;
        while (tempA != tempB) {
            if (tempA == null) {
                tempA = headB;
            } else {
                tempA = tempA.next;
            }
            if (tempB == null) {
                tempB = headA;
            } else {
                tempB = tempB.next;
            }

        }
        return tempA;

    }
}
