package niuke.design;

/**
 * @description: 设计LRU缓存结构
 * @author: lzy
 * @time: 2024/8/15 16:16
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 双向链表结点定义
 */
class Node {
    public int key;
    public int val;
    public Node pre;
    public Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class BM100 {

    private Map<Integer,Node> map = new HashMap();
    private Node left = null;
    private Node right = null;
    private int capacity;
    public BM100(int capacity) {
        // write code here
        this.capacity = capacity;
        //left指向最久未使用的结点 right指向最新的结点
        left = new Node(-1,-1);
        right = new Node(-1,-1);
        left.next = right;
        right.pre = left;
    }

    public int get(int key) {
        // write code here
        if (map.containsKey(key)) {
            Node node = map.get(key);
            //删除链表中的该结点node
            remove(node);
            //在最新位置加入该结点
            insert(key,node.val);
            return node.val;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        // write code here
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(key,value);
        } else {
            if (map.size() == capacity) {
                //置换出最近最久未使用的结点
                Node del = left.next;
                remove(del);
                insert(key,value);
            } else {
                insert(key,value);
            }
        }
    }

    private void insert(int key, int val) {
        Node cur = new Node(key, val);
        Node pre = right.pre;
        cur.pre = pre;
        cur.next = right;
        pre.next = cur;
        right.pre = cur;
        map.put(key,cur);
    }


    private void remove(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        pre.next = next;
        next.pre = pre;
        map.remove(node.key,node);
    }
}
