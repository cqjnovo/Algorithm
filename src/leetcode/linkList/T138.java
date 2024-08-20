package leetcode.linkList;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 随机链表复制
 * @author: lzy
 * @time: 2024/8/20 8:38
 */
public class T138 {
    public Node copyRandomList(Node head) {
        //定义一个map 其中key为源链表的结点，value为新链表中对应的结点
        Map<Node,Node> srcToDst = new HashMap<>();
        //新链表的头结点，当作哨兵结点，方便复制第一个结点
        Node dst = new Node(0);
        Node p = dst;
        Node q = head;
        //先拷贝源链表的next域和val域的值
        while (q != null) {
            Node cur = new Node(q.val);
            p.next = cur;
            p = cur;
            //将复制出来的新结点和源结点put进map以备后用
            srcToDst.put(q,p);
            q = q.next;
        }
        p = dst.next;
        q = head;
        //再根据map中存的映射关系，给新链表中每一个结点的random域赋值
        while (p != null && q != null) {
            if (q.random == null) {
                p.random = null;
            } else {
                p.random = srcToDst.get(q.random);
            }
            p = p.next;
            q = q.next;
        }
        return dst.next;
    }
}

/**
 * 随机链表结点定义
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
