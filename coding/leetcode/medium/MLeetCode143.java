package leetcode.medium;

import leetcode.compitetion.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyunlong
 * @date 2021/6/1 9:13 下午
 * @description 重排链表
 */
public class MLeetCode143 {

    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            ListNode a = tmp;
            list.add(tmp);
            tmp = tmp.next;
            a.next = null;
        }

        ListNode temp2 = head;
        for (int i = 0; i < list.size(); i++) {
            ListNode index = null;
            if (i % 2 == 0) {
                index = list.get(i / 2);
            } else {
                index = list.get(list.size() - 1 - (i - 1) / 2);
            }
            temp2.next = index;
            temp2 = temp2.next;
        }
    }
}
