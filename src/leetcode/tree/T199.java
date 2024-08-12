package leetcode.tree;

import leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description:二叉树的右视图(层序遍历中每一层最右边的那个结点)
 * @author: lzy
 * @time: 2024/8/10 8:27
 */
public class T199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //当前层中结点个数
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = queue.poll();
                if (i == sz - 1) {
                    res.add(cur.val);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return res;
    }
}
