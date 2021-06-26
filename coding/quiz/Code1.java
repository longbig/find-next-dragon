package quiz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author yuyunlong
 * @date 2021/6/15 8:42 下午
 * @description
 */
public class Code1 {

    public List<Character> solve(List<String> input) {
        //["a: b, c", "b: d", .....,"d: e"]
        List<Node1> allNodes = new ArrayList<>();
        for (String s : input) {
            String[] arrayS = s.split(":");
            Node1 node1 = new Node1(arrayS[0].charAt(0));
            String[] depenciS = arrayS[1].split(",");
            ArrayList<Node1> depencies = new ArrayList<>();
            for (String depenci : depenciS) {
                Node1 de = new Node1(depenci.charAt(0));
                depencies.add(de);
            }
            node1.depencies = depencies;
            allNodes.add(node1);
        }
        //单独处理没有依赖的结点
        for (String s : input) {
            String[] arrayS = s.split(":");
            String[] depenciS = arrayS[1].split(",");
            for (String depenci : depenciS) {
                isContainsNode(allNodes, new Node1(depenci.charAt(0)));
            }
        }

        //打印
        for (Node1 allNode : allNodes) {
            ArrayList<Node1> list = allNode.depencies;
            System.out.print(allNode.value + ":");
            if (list != null) {
                for (Node1 node1 : list) {
                    System.out.print(node1.value + " ");
                }
            }
            System.out.println();

        }


        List<Character> result = new ArrayList<>();
        //找根节点

        while (!allNodes.isEmpty()) {
            Node1 root = null;
            for (int i = 0; i < allNodes.size(); i++) {
                Node1 currentNode = allNodes.get(i);
                for (int j = 0; j < allNodes.size(); j++) {
                    ArrayList<Node1> nodeDepencies = allNodes.get(j).depencies;
                    if (nodeDepencies != null) {
                        Node1 next = nodeDepencies.get(0);
                        if (currentNode.value == next.value) {
                            root = null;
                            break;
                        } else {
                            root = currentNode;
                        }
                    }

                }

                if (root != null) {
                    result.add(root.value);
                    allNodes.remove(root);
                    break;
                }
                if (allNodes.size() == 1) {
                    result.add(allNodes.get(0).value);
                    allNodes.remove(0);
                    break;
                }
            }
        }

        return result;
    }

    //单独处理没有依赖的结点
    private void isContainsNode(List<Node1> allNodes, Node1 de) {
        boolean flag = false;
        for (Node1 allNode : allNodes) {
            if (allNode.value == de.value) {
                flag = true;
            }
        }
        if (!flag) {
            allNodes.add(de);
        }
    }

    public static void main(String[] args) {
        String s1 = "a:b,c";
        String s2 = "b:d";
        String s3 = "c:e";
        String s4 = "d:e";
        List<String> input = new ArrayList<>();
        input.add(s1);
        input.add(s2);
        input.add(s3);
        input.add(s4);
        Code1 test = new Code1();
        List<Character> result = test.solve(input);
        System.out.println();
        for (int i = result.size() - 1; i >= 0; i--) {
            System.out.println(result.get(i));
        }
    }

}
