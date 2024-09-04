package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: lzy
 * @time: 2024/9/4 9:24
 */
public class BSTIterator {

    public List<Integer> list;
    public int cur;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        cur = -1;
        inOrder(root);
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    public int next() {
        return list.get(++cur);
    }

    public boolean hasNext() {
        return cur < list.size() - 1;
    }
}
