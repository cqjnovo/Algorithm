package leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description:求数组中第k大的数
 * @author: lzy
 * @time: 2024/8/9 9:08
 */
public class T215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((t1, t2) -> t2 - t1);
        for (int num : nums) {
            pq.offer(num);
        }
        for (int i = 1; i < k; i++) {
            pq.poll();
        }
        return pq.peek();
    }
}
