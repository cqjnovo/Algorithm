package leetcode.imitate;

import java.util.Arrays;

/**
 * @description:
 * @author: lzy
 * @time: 2024/9/16 9:10
 */
public class T1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int cnt = 0;
        int sum = Arrays.stream(distance).sum();
        int i = start;
        while (i != destination) {
            cnt += distance[i];
            i = (i + 1) % distance.length;
        }
        return Math.min(cnt,sum - cnt);
    }
}
