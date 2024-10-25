package leetcode.dp;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * @description: 0/1背包问题
 * @author: lzy
 * @time: 2024/10/25 11:51
 */
public class T3180 {
    public int maxTotalReward(int[] rewardValues) {
        int n = rewardValues.length;
        Arrays.sort(rewardValues);
        int mx = rewardValues[n - 1];
        boolean[] dp = new boolean[mx * 2];
        dp[0] = true;
        //对于前i个数中，是否可以表示值为j的数
        for (int i = 0; i < n; i++) {
            int v = rewardValues[i];
            for (int j = 2 * v - 1; j >= v; j--) {
                dp[j] = dp[j] || dp[j - v];
                if (dp[j] == true && j > mx) {
                    mx = j;
                }
            }
        }
        return mx;
    }
}
