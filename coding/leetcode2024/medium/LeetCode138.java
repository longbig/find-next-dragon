package leetcode2024.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @date 2024/8/20 8:56
 * @description 138. 随机链表的复制
 *
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 *
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 *
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 *
 * 返回复制链表的头节点。
 */
public class LeetCode138 {

    public Node copyRandomListForZijian(Node head) {
        if (head == null) {
            return null;
        }
        Node temp = new Node(0);
        List<Node> newNodeList = new ArrayList<>();
        List<Node> oldNodeList = new ArrayList<>();
        List<Integer> indexList = new ArrayList<>();

        Node newHead = temp;
        while (head != null) {
            Node currNode = new Node(head.val);
            newHead.next = currNode;
            newNodeList.add(currNode);
            oldNodeList.add(head);

            head = head.next;
            newHead = newHead.next;
        }
        //遍历找下标
        for (Node node : oldNodeList) {
            if (node.random != null) {
                for (int i = 0; i < oldNodeList.size(); i++) {
                    if (oldNodeList.get(i).equals(node.random))
                        indexList.add(i);
                }
            } else {
                indexList.add(null);
            }
        }
        //设置random
        for (int i = 0; i < newNodeList.size(); i++) {
            if (indexList.get(i) != null) {
                newNodeList.get(i).random = newNodeList.get(indexList.get(i));
            }
        }
        return temp.next;

    }

    private Map<Node, Node> nodeMap = new HashMap<>();

    /**
     * 官方递归解法
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!nodeMap.containsKey(head)) {
            Node newHead = new Node(head.val);
            nodeMap.put(head, newHead);
            newHead.next = copyRandomList(head.next);
            newHead.random = copyRandomList(head.random);
        }
        return nodeMap.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
