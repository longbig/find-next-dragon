package quiz;

import leetcode.compitetion.ListNode;

/**
 * @author yuyunlong
 * @date 2021/6/28 2:51 下午
 * @description
 */
public class Code03 {

    public ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null, curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }
}
