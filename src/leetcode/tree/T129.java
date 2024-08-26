package leetcode.tree;

/**
 * @description: 求根节点到叶节点数字之和
 * @author: lzy
 * @time: 2024/8/26 8:25
 */
public class T129 {
    private int res = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        return res;
    }

    public void dfs(TreeNode node, String path) {
        if (node == null) {
            return;
        }
        path = path + node.val;
        if (node.left == null && node.right == null) {
            res += Integer.parseInt(path);
        }
        dfs(node.left,path);
        dfs(node.right,path);
    }

    /**
     * 重载方法dfs-传int可以极大地提高效率
     * @param node
     * @param preSum
     */
    public void dfs(TreeNode node, int preSum) {
        if (node == null) {
            return;
        }
        preSum = preSum * 10 + node.val;
        if (node.left == null && node.right == null) {
            res += preSum;
        }
        dfs(node.left,preSum);
        dfs(node.right,preSum);
    }
}
