package leetcode.tree;

import java.util.Arrays;

/**
 * @description: 将有序数组转换为二叉搜索树
 * @author: lzy
 * @time: 2024/8/30 10:43
 */
public class T108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        //如果数组为空，无需继续构造，直接返回null
        if (nums.length == 0) {
            return null;
        }
        //否则找nums的中间结点作为root
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        //将左区间和右区间分别截取出来，递归的进行左右子树的构建
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid + 1, nums.length);
        root.left = sortedArrayToBST(left);
        root.right = sortedArrayToBST(right);
        //当左右子树构建完毕后，返回根节点
        return root;
    }
}
