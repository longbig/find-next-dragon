package leetcode2021.compitetion;

/**
 * @author yuyunlong
 * @date 2021/1/10 11:06 上午
 * @description
 */
public class LeetCode5652 {

    public ListNode swapNodes(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode start = new ListNode();
        ListNode end = new ListNode();
        ListNode head1 = head, head2 = head;
        int count = 0;
        while(head != null) {
            count++;
            if (count == k) {
                start.next = head;
            }
            head = head.next;
        }

        int tail = count - k + 1;
        count = 0;
        while (head1 != null) {
            count++;
            if (count == tail) {
                end.next = head1;
            }
            head1 = head1.next;
        }
        int temp = start.next.val;
        start.next.val = end.next.val;
        end.next.val = temp;
        return head2;


    }

}
