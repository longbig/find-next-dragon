package leetcode2024.medium;

import leetcode2021.compitetion.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @date 2024/8/20 16:38
 * @description 排序链表
 */
public class LeetCode148 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list = list.stream().sorted(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        }).collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                list.get(i).next = null;
                continue;
            }
            list.get(i).next = list.get(i + 1);
        }

        return list.get(0);
    }
}
