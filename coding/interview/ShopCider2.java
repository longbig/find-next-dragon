package interview;

import leetcode2021.compitetion.ListNode;

/**
 * @author yuyunlong
 * @date 2021/6/8 9:22 下午
 * @description
 */
public class ShopCider2 {

    public ListNode reverse(ListNode head, int start, int end) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode pre = null, next = null, curr = fakeHead;

        while ((start-1) != 0) {
            curr = curr.next;
            start--;
        }
        pre = curr;
        ListNode secondTail = pre.next;

        int second = end - start + 1;
        while (second >= 0) {
            curr = curr.next;
            second--;
        }
        next = curr;

        ListNode newHead = reversList(pre, next);
        pre.next = newHead;
        secondTail.next = next;

        return fakeHead.next;
    }

    private ListNode reversList(ListNode head, ListNode tail) {
        ListNode pre = null, curr = head;
        while (curr != tail) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ShopCider2 test = new ShopCider2();
        test.reverse(l1, 1, 3);

        while (l1 != null) {
            System.out.println(l1.val);
            l1 = l1.next;
        }

    }
}
