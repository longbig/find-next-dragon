package meituan;

import leetcode.compitetion.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyunlong
 * @date 2021/6/1 9:13 下午
 * @description 重排链表
 */
public class MLeetCode143 {

    //官方解法：找到中间结点，反转后半部分，再遍历
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        //快慢指针找中间结点
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode l2 = mid.next;
        mid.next = null;
        //反转链表
        ListNode root = l2, pre = null;
        while (root != null) {
            ListNode temp = root.next;
            root.next = pre;
            pre = root;
            root = temp;
        }

        //pre是另一半头结点，直接合并两个链表
        mergeList(head, pre);
    }

    private void mergeList(ListNode root1, ListNode root2) {
        ListNode temp1;
        ListNode temp2;
        while (root1 != null && root2 != null) {
            temp1 = root1.next;
            temp2 = root2.next;

            root1.next = root2;
            root1 = temp1;

            root2.next = root1;
            root2 = temp2;
        }
    }


        public void reorderList1(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            ListNode a = tmp;
            list.add(tmp);
            tmp = tmp.next;
            a.next = null;
        }

        ListNode temp2 = head;
        ListNode index = null;
        for (int i = 0; i < list.size(); i++) {

            if (i % 2 == 0) {
                index = list.get(i / 2);
            } else {
                index = list.get(list.size() - 1 - i / 2);
            }
            temp2.next = index;
            temp2 = temp2.next;
        }
        if (index != null) {
            index.next = null;
        }
    }
}
