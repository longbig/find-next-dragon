package leetcode2024.easy;

import leetcode2021.compitetion.ListNode;

/**
 * @author yuyunlong
 * @date 2024/8/12 23:19
 * @description 反转链表
 */
public class LeetCode206 {

    //迭代方法，2025年2月24日重新写，思路：设置前后两个指针遍历链表
    public ListNode reverseListForDiedai1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    //递归方法，2025年2月24日重新写，思路，把链表看做：头节点 + 后面的节点，当做两个节点来做就行
    public ListNode reverseListForDigui1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListForDigui1(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;

    }


    //迭代的方法
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = head, pre = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;

    }


    /**
     * 按递归的方法
     * @param head
     * @return
     */
    public ListNode reverseListForDigui(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = reverseListForDigui(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        h1.next = h2;
        h2.next = h3;
        LeetCode206 leetCode206 = new LeetCode206();
        ListNode hh = leetCode206.reverseList(h1);

        System.out.println(hh.val + " " + hh.next.val + " " + hh.next.next.val);

    }
}
