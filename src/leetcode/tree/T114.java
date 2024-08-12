package leetcode.tree;

/**
 * @description:二叉树展开为链表
 * @author: lzy
 * @time: 2024/8/12 17:59
 * 如果当前结点的左孩子不为空，找到左孩子的最右下结点p，
 * 通过 p.right = cur.right; cur.right = cur.left; cur.left = null将左孩子融合到该树右侧
 */
public class T114 {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                //p结点为一个探路结点，找到左子树的最右下结点
                TreeNode p = cur.left;
                while (p.right != null) {
                    p = p.right;
                }
                //融合左子树进右边的分支
                p.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}
