package leetcode.tree;

import java.util.*;

/**
 * @description: 二叉树的锯齿形层序遍历
 * @author: lzy
 * @time: 2024/8/25 10:15
 */
public class T103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int layer = 1;
        //奇数层 从左向右 偶数层 从右向左
        while (!queue.isEmpty()) {
            int sz = queue.size();
            List<Integer> curLayer = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = queue.poll();
                curLayer.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            if (layer % 2 == 0) {
                Collections.reverse(curLayer);
            }
            res.add(curLayer);
            layer += 1;
        }
        return res;
    }
}
