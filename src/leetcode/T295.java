package leetcode;

import java.util.PriorityQueue;

public class T295 {
    PriorityQueue<Integer> maxHeap = null;
    PriorityQueue<Integer> minHeap = null;
    public T295() {
        maxHeap = new PriorityQueue<>((i,j) -> {return j-i;});
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        //调整堆，保证大根堆中元素个数比小根堆中元素个数最多多1个
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.peek());
            minHeap.poll();
        }
        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.peek());
            maxHeap.poll();
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return (double) maxHeap.peek();
        }
    }
}
