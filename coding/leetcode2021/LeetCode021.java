package leetcode2021;

import leetcode2021.compitetion.ListNode;

/**
 * @author yuyunlong
 * @date 2021/1/10 5:26 下午
 * @description 合并两个有序列表
 */
public class LeetCode021 {

    /**
     * 递归的方式
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
