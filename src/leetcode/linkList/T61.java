package leetcode.linkList;

import java.util.List;

/**
 * @description: 旋转链表
 * @author: lzy
 * @time: 2024/8/24 10:01
 * 将表中每个结点向右旋转k次
 */
public class T61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        //首先,需要统计出链表中结点个数,k %= n即为有效旋转次数
        int n = 0;
        ListNode p = head;
        while (p != null) {
            n += 1;
            p = p.next;
        }
        k %= n;
        if (k == 0) {
            return head;
        }
        //pre指向需要断开位置的前一个位置
        //cur指向需要断开的位置
        //旋转k次即为 从cur开始往后的链表 需要放到最前面
        ListNode pre = null;
        ListNode cur = head;
        int i = 0;
        while (i < n - k) {
            pre = cur;
            cur = cur.next;
            i += 1;
        }
        pre.next = null;
        //使用指针p去找cur的末尾位置
        p = cur;
        while (p.next != null) {
            p = p.next;
        }
        p.next = head;
        return cur;
    }
}
