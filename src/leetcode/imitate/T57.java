package leetcode.imitate;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 插入区间
 * @author: lzy
 * @time: 2024/8/19 19:29
 */
public class T57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        if (n == 0) {
            return new int[][] {newInterval};
        }
        boolean flag = false;
        while (i < n) {
            if (intervals[i][1] < newInterval[0]) {
                res.add(intervals[i]);
                i += 1;
            } else if (newInterval[1] < intervals[i][0]) {
                if (!flag) {
                    res.add(newInterval);
                    flag = true;
                } else {
                    res.add(intervals[i]);
                    i += 1;
                }
            } else {
                //否则需要合并区间
                int j = i;
                int start = Math.min(newInterval[0],intervals[j][0]);
                int end = Math.max(newInterval[1],intervals[j][1]);
                while (j < n && intervals[j][0] <= end) {
                    end = Math.max(intervals[j][1],end);
                    j += 1;
                }
                flag = true;
                res.add(new int[]{start,end});
                i = j;
            }
        }
        //flag = true标志着新区间已经被融入源区间内
        if (!flag) {
            res.add(newInterval);
        }
        return res.toArray(new int[0][]);
    }
}
