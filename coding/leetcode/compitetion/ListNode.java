package leetcode.compitetion;

/**
 * @author yuyunlong
 * @date 2021/1/10 11:06 上午
 * @description
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
