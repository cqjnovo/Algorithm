package leetcode.linkList;

/**
 * @description: 环路检测
 * 快慢指针解法:找出环路的起始位置
 * @author: lzy
 * @time: 2024/12/3 10:14
 */
public class M0208 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            //慢指针一次走一步
            slow = slow.next;
            //快指针一次走两步
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                //否则说明走到了末尾，那就不存在环路
                break;
            }
            //如果两指针相遇了，说明存在环路，那么就要去找环路的起点
            if (fast == slow) {
                slow = head;
                //慢指针从头结点出发，与快指针从相遇点出发，两者再次相遇的位置即为环路起点
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
