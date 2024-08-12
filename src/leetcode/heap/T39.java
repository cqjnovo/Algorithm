package leetcode.heap;

import java.util.*;

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

//使用小根堆 合并k个有序链表
public class T39 {
    Comparator<ListNode> comparator = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode t0, ListNode t1) {
            if (t0.val > t1.val) {
                return 1;
            } else if (t0.val < t1.val) {
                return -1;
            } else {
                return 0;
            }
        }
    };

    Comparator<String> comparator1 = new Comparator<String>() {
        @Override
        public int compare(String a, String b) {
            return a.compareTo(b);
        }
    };
    public ListNode mergeKLists (ArrayList<ListNode> lists) {
        // write code here
        ListNode head = null;
        ListNode temp = null;
//        Comparator<ListNode> comparator = Comparator.comparing(o -> o.val);
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(comparator);
        for (ListNode p : lists) {
            priorityQueue.add(p);
        }
        while (!priorityQueue.isEmpty()) {
            ListNode cur = priorityQueue.remove();
            if (cur.next != null) {
                priorityQueue.add(cur.next);
            }
            if (head == null) {
                head = cur;
                temp = head;
            } else {
                temp.next = cur;
                temp = temp.next;
            }
        }
        return head;
    }


}
