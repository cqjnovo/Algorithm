package leetcode.hashSet;

import java.util.HashSet;

/**
 * @description:
 * @author: lzy
 * @time: 2024/11/29 20:48
 */
public class R023 {

    /**
     * 方法1：借助hashSet，额外使用O(n)的空间复杂度
     * 使用hashSet存储链表a中的每一个结点，当遍历链表b时，第一个遇到的hashSet中元素即为所求
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p = headA, q = headB;
        while (p != null) {
            set.add(p);
            p = p.next;
        }
        while (q != null) {
            if (set.contains(q)) {
                return q;
            }
            q = q.next;
        }
        return null;
    }

    /**
     * 方法2：统计两个链表的长度，将长链表先往后移动(长-短)个位置，保证两个链表从相同的位置出发(对齐)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        int cnt = 0;
        while (p != null) {
            cnt += 1;
            p = p.next;
        }
        while (q != null) {
            cnt -= 1;
            q = q.next;
        }
        //两者不一般长，需要调整长链表，使两个链表从同一个位置出发
        p = cnt > 0 ? headA : headB;
        q = p == headA ? headB : headA;
        cnt = Math.abs(cnt);
        while (cnt > 0) {
            p = p.next;
            cnt -= 1;
        }
        //对齐之后，同时向后找，当遇到两个指针指向相同的位置时，就是第一个交点处
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }
}
