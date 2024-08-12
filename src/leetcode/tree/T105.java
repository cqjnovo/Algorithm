package leetcode.tree;

import leetcode.tree.TreeNode;

import java.util.Arrays;

/**
 * @description:
 * @author: lzy
 * @time: 2024/8/10 8:02
 */
public class T105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) {
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
        int[] leftPre = Arrays.copyOfRange(preorder,1,1+leftIn.length);
        root.left = buildTree(leftPre,leftIn);
        int[] rightIn = Arrays.copyOfRange(inorder,idx+1,inorder.length);
        int[] rightPre = Arrays.copyOfRange(preorder,1+leftPre.length,preorder.length);
        root.right = buildTree(rightPre,rightIn);
        return root;
    }
}
