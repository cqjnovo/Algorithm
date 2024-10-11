package leetcode.binSearch;

import java.security.interfaces.RSAMultiPrimePrivateCrtKey;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @description:
 * @author: lzy
 * @time: 2024/10/2 9:31
 */
public class T1870 {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        if (n - 1 >= hour) {
            return -1;
        }
        int totalDist = Arrays.stream(dist).sum();
        int speed = 10000000;
        int l = 1;
        int r = speed;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (!valid(dist,hour,mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean valid(int[] dist, double hour, int speed) {
        int n = dist.length;
        double cnt = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                cnt += (double) dist[i] / speed;
            } else {
                if (dist[i] % speed == 0) {
                    cnt += dist[i] / speed;
                } else {
                    cnt += (dist[i] / speed + 1);
                }
            }
        }
        return cnt <= hour;
    }
}
