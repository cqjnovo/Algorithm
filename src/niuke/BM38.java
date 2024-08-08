package niuke;

/**
 * @description:
 * @author: lzy
 * @time: 2024/8/8 15:53
 */
public class BM38 {
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        if (root == null) {
            return -1;
        }
        if (root.val == o1 || root.val == o2) {
            return root.val;
        }
        int left = -1, right = -1;
        left = lowestCommonAncestor(root.left, o1, o2);
        right = lowestCommonAncestor(root.right, o1, o2);
        if (left != -1 && right != -1) {
            return root.val;
        }
        if (left != -1) {
            return left;
        }
        return right;
    }
}
