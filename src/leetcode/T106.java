package leetcode;

import java.util.Arrays;

/**
 * @description: 根据后序和中序遍历序列建立二叉树
 * @author: lzy
 * @time: 2024/8/10 8:13
 */
public class T106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        if (postorder.length == 1) {
            return root;
        }
        int idx = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                idx = i;
                break;
            }
        }
        int[] leftIn = Arrays.copyOfRange(inorder,0,idx);
        int[] rightIn = Arrays.copyOfRange(inorder,idx + 1,inorder.length);
        int[] rightPost = Arrays.copyOfRange(postorder,postorder.length - 1 - rightIn.length,postorder.length - 1);
        int[] leftPost = Arrays.copyOfRange(postorder,0,leftIn.length);
        root.left = buildTree(leftIn,leftPost);
        root.right = buildTree(rightIn,rightPost);
        return root;
    }
}
