package quiz;

import leetcode.compitetion.ListNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 两个链表生成相加链表
 * @author yuyunlong
 * @time 2021/5/10 9:42 上午
 * @description
 */
public class Niuke02 {

    public ListNode addInList (ListNode head1, ListNode head2) {
        int num1 = 0, num2 = 0;
        while(head1 != null) {
            num1 = num1 * 10 + head1.val;
            head1 = head1.next;
        }
        while (head2 != null) {
            num2 = num2 * 10 + head2.val;
            head2 = head2.next;
        }
        int num = num1 + num2;
        Stack<Integer> stack = new Stack<>();
        while (num != 0) {
            stack.push(num % 10);
            num /= 10;
        }
        ListNode root = new ListNode(stack.pop());
        ListNode head = root;
        while (!stack.isEmpty()) {
            ListNode node = new ListNode(stack.pop());
            root.next = node;
            root = root.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        ListNode head11 = new ListNode(0);
        head1.next = head11;
        ListNode head2 = new ListNode(9);
        ListNode head22 = new ListNode(8);
        head2.next = head22;
        Niuke02 test = new Niuke02();
        ListNode rest = test.addInList(head1, head2);
        while (rest != null) {
            System.out.println(rest.val);
            rest = rest.next;
        }
    }
}
