package leetcode2024.hard;

import leetcode2021.compitetion.ListNode;

/**
 * @author yuyunlong
 * @date 2024/10/6 12:08
 * @description
 */
public class LeetCode023 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length < 2) {
            return lists[0];
        }

        for (int i = 1; i < lists.length; i++) {
            lists[i] = mergeTwoLists(lists[i], lists[i - 1]);
        }
        return lists[lists.length - 1];

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }

    }
}
