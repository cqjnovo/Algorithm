package leetcode.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @description: 用最少数量的箭射爆气球
 * @author: lzy
 * @time: 2024/8/16 18:42
 */
public class T452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(p1,p2) -> {
            return p1[0] == p2[0] ? Integer.compare(p1[1],p2[1]) : Integer.compare(p1[0],p2[0]);
        });
        int n = points.length;
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < n) {
            j = i;
            //维护start,end为所有区间的交集，这些子区间内的气球可以用一根箭射爆
            int start = points[i][0];
            int end = points[i][1];
            while (j < n && points[j][0] <= end) {
                start = Math.max(start,points[j][0]);
                end = Math.min(end,points[j][1]);
                j += 1;
            }
            res += 1;
            i = j;
        }
        return res;
    }
}
