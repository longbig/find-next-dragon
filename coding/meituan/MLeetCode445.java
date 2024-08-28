package meituan;

import leetcode2021.compitetion.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyunlong
 * @date 2021/6/9 2:58 下午
 * @description 两数相加II
 */
public class MLeetCode445 {

    /**
     * 进阶：不能反转输入链表
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        List<Integer> val1 = new ArrayList<>();
        List<Integer> val2 = new ArrayList<>();
        while (l1 != null) {
            val1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            val2.add(l2.val);
            l2 = l2.next;
        }

        int index1 = val1.size() - 1, index2 = val2.size() - 1, extra = 0;
        ListNode ans = null;
        while (index1 >= 0 || index2 >= 0 || extra != 0) {
            int x = index1 < 0 ? 0 : val1.get(index1);
            int y = index2 < 0 ? 0 : val2.get(index2);
            int sum = x + y + extra;


            //注意：这里有个非常巧妙的建链表的方法
            ListNode curr = new ListNode(sum % 10);
            curr.next = ans;
            ans = curr;

            extra = sum / 10;
            index1--;
            index2--;
        }
        return ans;

    }



}
