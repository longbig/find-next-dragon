package leetcode2025;

import leetcode2021.compitetion.ListNode;

/**
 * @author yuyunlong
 * @date 2025/7/27 17:51
 * @description
 */
public class LeetCode021 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        //双指针解法，递归写法
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }

    }
}
