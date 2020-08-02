package leetcode;

/**
 * @author yuyunlong
 * @date 2020/8/2 5:39 下午
 * @description
 */
public class TreeNode { int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
