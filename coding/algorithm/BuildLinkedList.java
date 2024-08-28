package algorithm;

import leetcode2021.compitetion.ListNode;

/**
 * @author yuyunlong
 * @date 2021/6/9 5:58 下午
 * @description 从尾到头建立单链表，方法来源于LeetCode445
 */
public class BuildLinkedList {

    /**
     * 从尾到头建链表，记住方法
     * @param array
     * @return
     */
    private ListNode buildLink(int[] array) {
        ListNode head = null;
        for (int i = 0; i < array.length; i++) {
            ListNode temp = new ListNode(array[i]);
            temp.next = head;
            head = temp;
        }
        return head;
    }
}
