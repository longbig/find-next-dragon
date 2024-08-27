package leetcode2021.easy;

import leetcode2021.compitetion.ListNode;

/**
 * @author yuyunlong
 * @date 2021/5/21 10:52 上午
 * @description 相交链表
 */
public class LeetCode160 {

    //A+B和B+A长度一样，所以两个指针分别遍历，有交点一定会在交点同时相遇，没有的话，也会同时到尾结点
    //最后判断尾结点是否一样即可
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode head1 = headA;
        ListNode head2 = headB;
        while (headA != headB) {
            if (headA != null) {
                headA = headA.next;
            } else {
                headA = head2;
            }

            if (headB != null) {
                headB = headB.next;
            } else {
                headB = head1;
            }
        }
        return headA;
    }

    /**
     * 自己做法：先找出差的长度，长的一方先走差的长度，最后一起走，判断节点是否相等
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode rootA = new ListNode(0, headA);
        ListNode rootB = new ListNode(0, headB);
        while (rootA != null) {
            lenA++;
            rootA = rootA.next;
        }
        while (rootB != null) {
            lenB++;
            rootB = rootB.next;
        }
        if (lenA == 1 || lenB == 1) {
            return null;
        }
        if (lenA > lenB) {
            int len = lenA - lenB;
            while (len != 0) {
                headA = headA.next;
                len--;
            }
        } else {
            int len = lenB - lenA;
            while (len != 0) {
                headB = headB.next;
                len--;
            }
        }

        while (headA != null && headB != null) {
            if (headA.equals(headB)) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
