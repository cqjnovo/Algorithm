package leetcode.priorityQueue;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @description:
 * @author: lzy
 * @time: 2024/10/20 10:29
 */
public class T414 {
    /**
     * 方法一:使用小根堆模拟
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        //先使用hashSet去除重复元素
        HashSet<Integer> hs = new HashSet<>();
        for (int n : nums) {
            if (!hs.contains(n)) {
                hs.add(n);
            }
        }
        if (hs.size() < 3) {
            return Collections.max(hs);
        }
        //否则将hs中所有元素加入到优先队列，建立小根堆
        Iterator<Integer> iterator = hs.iterator();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (iterator.hasNext()) {
            Integer x = iterator.next();
            pq.offer(x);
        }
        while (pq.size() > 3) {
            pq.poll();
        }
        return pq.peek();
    }

    /**
     * 方法二:使用三个变量a,b,c模拟最大、第二大、第三大三个元素
     * @param nums
     * @return
     */
    public int thirdMax_1(int[] nums) {
        long a = Long.MIN_VALUE, b = Long.MIN_VALUE, c = Long.MIN_VALUE;
        for (long num : nums) {
            if (num > a) {
                c = b;
                b = a;
                a = num;
            } else if (num > b && num < a) {
                c = b;
                b = num;
            } else if (num > c && num < b) {
                c = num;
            }
        }
        //如果当前第三大元素c仍然是最小值，说明nums中不满3个不同元素，返回最大值
        return c == Long.MIN_VALUE ? (int) a : (int) c;
    }
}
