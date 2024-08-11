package leetcode;

/**
 * @description: 将二叉搜索树转化为排序的双向链表
 * @author: lzy
 * @time: 2024/8/11 21:26
 */
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
public class LCR115 {

    public Node head = null;

    public Node pre = null;
    public Node treeToDoublyList(Node root) {
        inOrder(root);
        if (head == null) {
            return root;
        }
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void inOrder(Node cur) {
        if (cur == null) {
            return;
        }
        inOrder(cur.left);
        if (head == null) {
            head = cur;
        } else {
            cur.left = pre;
            pre.right = cur;
        }
        pre = cur;
        inOrder(cur.right);
    }
}
