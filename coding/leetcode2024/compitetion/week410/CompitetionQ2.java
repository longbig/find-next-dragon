package leetcode2024.compitetion.week410;

import java.util.*;

/**
 * @author yuyunlong
 * @date 2024/8/11 11:22
 * @description 统计好节点的数目
 * <p>
 * 现有一棵 无向 树，树中包含 n 个节点，按从 0 到 n - 1 标记。树的根节点是节点 0 。给你一个长度为 n - 1 的二维整数数组 edges，其中 edges[i] = [ai, bi] 表示树中节点 ai 与节点 bi 之间存在一条边。
 * <p>
 * 如果一个节点的所有子节点为根的
 * 子树
 * 包含的节点数相同，则认为该节点是一个 好节点。
 * <p>
 * 返回给定树中 好节点 的数量。
 * <p>
 * 子树 指的是一个节点以及它所有后代节点构成的一棵树。
 */
public class CompitetionQ2 {

        private List<List<Integer>> tree;
        private int[] subtreeSize;
        private int goodNodes;

        public int countGoodNodes(int[][] edges) {
            int n = edges.length + 1;
            tree = new ArrayList<>(n);
            subtreeSize = new int[n];
            goodNodes = 0;

            for (int i = 0; i < n; i++) {
                tree.add(new ArrayList<>());
            }

            for (int[] edge : edges) {
                int a = edge[0], b = edge[1];
                tree.get(a).add(b);
                tree.get(b).add(a);
            }

            dfs(0, -1);

            return goodNodes;
        }

        private int dfs(int node, int parent) {
            int size = 1;
            List<Integer> childrenSizes = new ArrayList<>();

            for (int child : tree.get(node)) {
                if (child != parent) {
                    int childSize = dfs(child, node);
                    size += childSize;
                    childrenSizes.add(childSize);
                }
            }

            subtreeSize[node] = size;

            // Check if all child subtrees have the same size
            if (childrenSizes.isEmpty() || allEqual(childrenSizes)) {
                goodNodes++;
            }

            return size;
        }

        private boolean allEqual(List<Integer> list) {
            if (list.isEmpty()) return true;
            int first = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) != first) return false;
            }
            return true;
        }


    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}};
        CompitetionQ2 solution = new CompitetionQ2();
        int count = solution.countGoodNodes(edges);
        System.out.println(count);
    }

}
