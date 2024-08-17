package leetcode.doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description: 合并区间
 * @author: lzy
 * @time: 2024/8/17 18:44
 */
public class T56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i, j) -> {
            return i[0] == j[0] ? i[1] - j[1] : i[0]- j[0];
        });
        int i = 0;
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
        while (i < n) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int j = i;
            while (j < n && intervals[j][0] <= end) {
                start = Math.min(start,intervals[j][0]);
                end = Math.max(end,intervals[j][1]);
                j += 1;
            }
            list.add(new int[] {start,end});
            i = j;
        }
        return list.toArray(new int[list.size()][]);
    }
}
