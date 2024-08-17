package niuke.heap;

import niuke.sort.BM96;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: 滑动窗口的最大值
 * @author: lzy
 * @time: 2024/8/17 18:17
 */
public class BM45 {
    public static void main(String[] args) {
        BM45 solution = new BM45();
        solution.maxInWindows(null,0);
    }
    public ArrayList<Integer> maxInWindows (int[] num, int size) {
        // write code here
        PriorityQueue<Integer> pq = new PriorityQueue<>((t1, t2) -> {
            return Integer.compare(t2, t1);
        });
        ArrayList<Integer> res = new ArrayList<>();
        if (num.length < size || size == 0) {
            return res;
        }
        for (int i = 0; i < size; i++) {
            pq.offer(num[i]);
        }
        res.add(pq.peek());
        for (int j = size; j < num.length; j++) {
            pq.remove(num[j - size]);
            pq.offer(num[j]);
            res.add(pq.peek());
        }
        return res;
    }
}
