package niuke.tree;

import niuke.tree.TreeNode;

import java.util.Arrays;

/**
 * @description:根据前序和中序序列重建二叉树
 * @author: lzy
 * @time: 2024/8/9 11:00
 */
public class BM40 {
    public TreeNode reConstructBinaryTree (int[] preOrder, int[] vinOrder) {
        // write code here
        int n = preOrder.length;
        if (n == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[0]);
        int idx = 0;
        //找根节点在中序序列中的下标idx
        for (int i = 0; i < vinOrder.length; i++) {
            if (vinOrder[i] == preOrder[0]) {
                idx = i;
                break;
            }
        }
        //根据下标idx切分出左子树中序和前序序列
        //重建左子树
        int[] leftVin = Arrays.copyOfRange(vinOrder,0,idx);
        int[] leftPre = Arrays.copyOfRange(preOrder,1,1+leftVin.length);
        root.left = reConstructBinaryTree(leftPre,leftVin);

        //根据下标idx切分出右子树的中序和前序序列
        //重建右子树
        int[] rightVin = Arrays.copyOfRange(vinOrder,idx+1,vinOrder.length);
        int[] rightPre = Arrays.copyOfRange(preOrder,1+leftPre.length,1+leftPre.length+rightVin.length);
        root .right = reConstructBinaryTree(rightPre,rightVin);

        return root;

    }
}
