package niuke.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @description: 主持人调度(二)
 * @author: lzy
 * @time: 2024/8/16 16:36
 */
public class BM96 {
    public int minmumNumberOfHost (int n, int[][] startEnd) {
        // write code here
        Arrays.sort(startEnd, (t1, t2) -> {
            if (t1[0] == t2[0]) {
                return Integer.compare(t1[1],t2[1]);
            } else {
                return Integer.compare(t1[0],t2[0]);
            }
        });
        //定义一个优先级队列，用于存储每一个活动的结束时间
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(startEnd[0][1]);
        for (int i = 1; i < n; i++) {
            if (!pq.isEmpty() && startEnd[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.offer(startEnd[i][1]);
        }
        return pq.size();
    }
}
