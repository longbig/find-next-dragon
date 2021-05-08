package leetcode.medium;

import leetcode.compitetion.ListNode;

/**
 * @author yuyunlong
 * @date 2021/4/18 12:25 下午
 * @description 删除链表的倒数第 N 个结点
 */
public class LeetCode019 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tempNode = new ListNode(0, head);
        ListNode yaNode = tempNode;
        ListNode fastNode = head;
        for (int i = 0; i < n; i++) {
            fastNode = fastNode.next;
        }

        while (fastNode != null) {
            tempNode = tempNode.next;
            fastNode = fastNode.next;
        }
        tempNode.next = tempNode.next.next;
        return yaNode.next;
    }
}
