package niuke.design;

import java.util.*;

/**
 * 链表结点定义：存储 键、值、频率
 */
class LNode {
    public int key;
    public int val;
    public int freq;

    public LNode prev;
    public LNode next;

    public LNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.freq = 1;
        this.prev = null;
        this.next = null;
    }
}

/**
 * 频率-双向链表 freqMap中对应的双向链表结构
 */
class DeLinkedList {
    int size;
    LNode head = null;
    LNode tail = null;

    public DeLinkedList() {
        size = 0;
        head = new LNode(-1, -1);
        tail = new LNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public void add(LNode node) {
        LNode pre = tail.prev;
        pre.next = node;
        node.prev = pre;
        node.next = tail;
        tail.prev = node;
        size += 1;
    }

    public LNode delete(LNode node) {
        LNode pre = node.prev;
        LNode next = node.next;
        next.prev = pre;
        pre.next = next;
        size -= 1;
        return node;
    }
}

/**
 * @description: 设计LFU缓存结构
 * @author: lzy
 * @time: 2024/8/15 21:38
 */
public class BM101 {
    public static void main(String[] args) {
        BM101 solution = new BM101();
        int[][] operators = {{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {1, 2, 4}, {1, 3, 5}, {2, 2}, {1, 4, 4}, {2, 1}};
        int k = 3;
        int[] lfu = solution.LFU(operators, k);
        for (int i = 0; i < lfu.length; i++) {
            System.out.println(lfu[i]);
        }
    }

    //存储每一个key 对应的结点，以O(1)的时间找到这个key-val对
    public Map<Integer, LNode> nodeMap = new HashMap<>();

    //存放出现频率 和 这个频率中所有的元素构成的双向链表
    public Map<Integer, DeLinkedList> freqMap = new HashMap<>();

    public int minFreq = 1;

    public int[] LFU(int[][] operators, int k) {
        // write code here
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < operators.length; i++) {
            if (operators[i][0] == 1) {
                put(operators[i][1], operators[i][2], k);
            } else {
                res.add(get(operators[i][1]));
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public int get(int key) {
        //如果当前key存在于nodeMap,到其中去找
        if (nodeMap.containsKey(key)) {
            LNode node = nodeMap.get(key);
            //从源频率双向链表中删除 并在新频率双向链表中加入
            DeLinkedList oriList = freqMap.get(node.freq);
            oriList.delete(node);
            if (minFreq == node.freq && oriList.size == 0) {
                minFreq += 1;
            }
            node.freq += 1;
            if (!freqMap.containsKey(node.freq)) {
                freqMap.put(node.freq, new DeLinkedList());
            }
            DeLinkedList curList = freqMap.get(node.freq);
            curList.add(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int val, int k) {
        if (nodeMap.containsKey(key)) {
            LNode node = nodeMap.get(key);
            DeLinkedList oriList = freqMap.get(node.freq);
            oriList.delete(node);
            if (minFreq == node.freq && oriList.size == 0) {
                minFreq += 1;
            }
            node.val = val;
            node.freq += 1;
            nodeMap.put(key, node);
            if (!freqMap.containsKey(node.freq)) {
                freqMap.put(node.freq, new DeLinkedList());
            }
            DeLinkedList curList = freqMap.get(node.freq);
            curList.add(node);
        } else {
            if (nodeMap.size() == k) {
                //删除最小出现频率链表中最不经常被访问的结点
                DeLinkedList minFreqList = freqMap.get(minFreq);
                LNode deleted = minFreqList.delete(minFreqList.head.next);
                nodeMap.remove(deleted.key, deleted);
            }
            LNode cur = new LNode(key, val);
            nodeMap.put(key, cur);
            if (!freqMap.containsKey(1)) {
                freqMap.put(1, new DeLinkedList());
            }
            freqMap.get(1).add(cur);
            if (minFreq > 1) {
                minFreq = 1;
            }
        }
    }
}
