package leetcode.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: lzy
 * @time: 2024/8/28 9:25
 */
public class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}