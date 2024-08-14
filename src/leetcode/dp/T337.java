package leetcode.dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 打家劫舍(三)
 * @author: lzy
 * @time: 2024/8/14 21:48
 */
public class T337 {

    public int[] robTree(TreeNode node) {
        if (node == null) return new int[]{0,0};
        int[] left_dp = robTree(node.left);
        int[] right_dp = robTree(node.right);
        int val1 = node.val + left_dp[0] + right_dp[0];
        int val2 = Math.max(left_dp[0],left_dp[1]) + Math.max(right_dp[0],right_dp[1]);
        return new int[]{val2,val1};
    }
    public int rob(TreeNode root) {
        int[] res = robTree(root);
        return Math.max(res[0],res[1]);
    }
}
