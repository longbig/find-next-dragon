package quiz;

import java.util.ArrayList;

/**
 * @author yuyunlong
 * @date 2021/6/15 8:45 下午
 * @description
 */
public class Node1 {
    public char value;
    public ArrayList<Node1> depencies;

    Node1() {

    }

    Node1(char value) {
        this.value = value;
    }

    Node1(char value, ArrayList<Node1> depencies) {
        this.value = value;
        this.depencies = depencies;
    }

    public void removeNode(Node1 value) {
        depencies.remove(value);
    }

}
