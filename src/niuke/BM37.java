package niuke;

/**
 * @description:
 * @author: lzy
 * @time: 2024/8/8 18:05
 */
public class BM37 {
    public int lowestCommonAncestor(TreeNode root, int p, int q) {
        int x = root.val;
        if (p < x && q < x) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p > x && q > x) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return x;
        }
    }
}
