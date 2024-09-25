package leetcode.math;

/**
 * @description:1014:最佳观光组合
 * @author: lzy
 * @time: 2024/9/25 15:38
 */
public class T1014 {
    public int maxScoreSightseeingPair(int[] values) {
        int mx = 0, ans = 0;
        for (int j = 0; j < values.length; j++) {
            ans = Math.max(ans, mx + values[j] - j);
            mx = Math.max(mx, values[j] + j);
        }
        return ans;
    }
}
