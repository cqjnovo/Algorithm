package leetcode.heap;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 滑动窗口内最大值
 * 维护一个单调队列
 * @author: lzy
 * @time: 2024/8/18 12:42
 */
public class T239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        MonotoneQueue mq = new MonotoneQueue();
        for (int i = 0; i < k; i++) {
            mq.push(nums[i]);
        }
        res[0] = mq.getMax();
        for (int i = k; i < n; i++) {
            mq.pop(nums[i-k]);
            mq.push(nums[i]);
            res[i-k+1] = mq.getMax();
        }
        return res;
    }
}

/**
 * 自定义单调队列
 */
class MonotoneQueue {
    public LinkedList<Integer> queue = new LinkedList<>();

    public void pop(int val) {
        if (!queue.isEmpty() && val == queue.getFirst()) {
            queue.removeFirst();
        }
    }

    public void push(int val) {
        while (!queue.isEmpty() && val > queue.getLast()) {
            queue.removeLast();
        }
        queue.addLast(val);
    }

    public int getMax() {
        return queue.getFirst();
    }

}