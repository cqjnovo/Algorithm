package leetcode.dp;

/**
 * @description:
 * @author: lzy
 * 0 1 2 4 6 13
 * @time: 2024/9/20 19:23
 */
public class M0801 {
    public int waysToStep(int n) {
        int mod = 1000000007;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i - 3; j < i; j++) {
                if (j >= 0) {
                    dp[i] += dp[j];
                    dp[i] %= mod;
                }
            }

        }
        return dp[n];
    }
}
