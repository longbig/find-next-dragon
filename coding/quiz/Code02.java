package quiz;

import leetcode2021.TreeNode;

/**
 * @author yuyunlong
 * @date 2021/6/21 2:04 下午
 * @description
 */
public class Code02 {
//    给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
//    百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
//    最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//
//    例如，给定如下二叉树 root =[3,5,1,6,2,0,8,null,null,7,4]
//
//            ![二叉树](binarytree.png)
    private TreeNode ans = null;

    public TreeNode findCommon(TreeNode root, TreeNode p, TreeNode q) {
        //f(left) f(right)是否包含p或q，|| （当前结点是p，q，则左右需一个包含p或q ）
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean leftF = dfs(root.left, p, q);
        boolean rightF = dfs(root.right, p, q);
        if ((leftF && rightF) || ((root == p || root == q) && (leftF || rightF))) {
            ans = root;
        }
        return leftF || rightF || (root == p || root == q);
    }

    public static void main(String[] args) {
        Code02 test = new Code02();
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(6);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(0);
        TreeNode t7 = new TreeNode(8);
        TreeNode t8 = new TreeNode(7);
        TreeNode t9 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t5.left = t8;
        t5.right = t9;
        t3.left = t6;
        t3.right = t7;
        test.dfs(t1, t4, t9);
        System.out.println(test.ans.val);
    }

}
