package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 填充每个节点的下一个右侧结点指针Ⅱ
 * @author: lzy
 * @time: 2024/8/25 8:32
 */

class MyNode {
    public int val;
    public MyNode left;
    public MyNode right;
    public MyNode next;

    public MyNode() {}

    public MyNode(int _val) {
        val = _val;
    }

    public MyNode(int _val, MyNode _left, MyNode _right, MyNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
public class T117 {
    /**
     * 迭代法: BFS-层序遍历
     * @param root
     * @return
     */
    public MyNode connect1(MyNode root) {
        if (root == null) return root;
        Queue<MyNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                MyNode cur = queue.poll();
                if (i == sz - 1) {
                    cur.next = null;
                } else {
                    cur.next = queue.peek();
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return root;
    }

    /**
     * 递归法: DFS
     * @param root
     * @return
     */
    public MyNode connect(MyNode root) {
        if (root == null) {
            return root;
        }
        //如果当前结点左右孩子都不为空，那么左孩子的next就是右孩子
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
        }
        //如果左不空，右空，左孩子的next就通过getNext(root.next)找root的兄弟结点的孩子
        if (root.left != null && root.right == null) {
            root.left.next = getNext(root.next);
        }
        //如果右不空，还要给右孩子找next域
        if (root.right != null) {
            root.right.next = getNext(root.next);
        }
        //当前结点的左右孩子都处理完毕，需要递归的处理以左右孩子为根的子树
        connect(root.right);
        connect(root.left);
        return root;
    }

    public MyNode getNext(MyNode node) {
        if (node == null) {
            return null;
        }
        if (node.left != null) {
            return node.left;
        }
        if (node.right != null) {
            return node.right;
        }
        if (node.next != null) {
            return getNext(node.next);
        }
        return null;
    }
}
