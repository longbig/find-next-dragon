package leetcode2024.medium;

import leetcode2021.compitetion.ListNode;


/**
 * @author Administrator
 * @date 2024/8/20 16:38
 * @description 排序链表
 */
public class LeetCode148 {

    /**
     * 递归思想：采用自顶向下的归并排序解法
     * 两个步骤：
     * 切开
     * 排序
     * 合并
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //细节：fast必须要先走一步，假设只有2个节点，fast slow都从head开始走，fast走2步为null，slow走一步，指向第二个节点了，
        //导致链表没有切开，死循环了
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //切开
        ListNode tempNode = slow.next;
        slow.next = null;
        ListNode leftNode = sortList(head);
        ListNode rightNode = sortList(tempNode);
        //排序合并
        ListNode tempHead = new ListNode(0);
        ListNode h = tempHead;
        while (leftNode != null && rightNode != null) {
            if (leftNode.val < rightNode.val) {
                tempHead.next = leftNode;
                leftNode = leftNode.next;
            } else {
                tempHead.next = rightNode;
                rightNode = rightNode.next;
            }
            //TODO 注意这一步写的时候漏掉了
            tempHead = tempHead.next;
        }
        //链表长度不一样的情况
        tempHead.next = leftNode != null ? leftNode : rightNode;
        //返回新的头节点
        return h.next;
    }
}
