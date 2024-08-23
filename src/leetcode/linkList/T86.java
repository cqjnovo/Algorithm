package leetcode.linkList;


/**
 * @description: 分隔链表
 * @author: lzy
 * @time: 2024/8/23 10:52
 * 小于x的结点存在l1链表中，大于等于x的结点存在l2链表中，将两个链表拼接后返回
 */
public class T86 {
    public ListNode partition(ListNode head, int x) {
        ListNode l1 = new ListNode(-1);
        ListNode l2 = new ListNode(-1);
        ListNode p = l1, q = l2;
        while (head != null) {
            ListNode temp = head.next;
            head.next = null;
            if (head.val < x) {
                p.next = head;
                p = head;
            } else {
                q.next = head;
                q = head;
            }
            head = temp;
        }
        p.next = l2.next;
        return l1.next;
    }
}
