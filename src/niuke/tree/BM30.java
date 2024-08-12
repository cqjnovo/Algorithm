package niuke.tree;

/**
 * @description:二叉搜索树与双向链表
 * @author: lzy
 * @time: 2024/8/10 10:02
 */
public class BM30 {

    TreeNode head = null;

    TreeNode pre = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        inOrder(pRootOfTree);
        return head;
    }

    public void inOrder(TreeNode cur) {
        if (cur == null) {
            return;
        }
        inOrder(cur.left);
        if (pre != null) {
            cur.left = pre;
            pre.right = cur;
        } else {
            head = cur;
        }
        pre = cur;
        inOrder(cur.right);
    }
}
