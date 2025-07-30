package leetcode2025;

import leetcode2021.compitetion.ListNode;

/**
 * @author yuyunlong
 * @date 2025/7/30 23:13
 * @description
 */
public class LeetCode160 {

    //用两个指针遍历链表，遍历到头后，从另一个链表接着遍历，这样相交时走过的距离一样，也是交点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode indexA = headA, indexB = headB;
        while (indexA != indexB) {
            if (indexA == null) {
                indexA = headB;
            } else {
                indexA = indexA.next;
            }

            if (indexB == null) {
                indexB = headA;
            } else {
                indexB = indexB.next;
            }
        }
        return indexA;
    }
}
