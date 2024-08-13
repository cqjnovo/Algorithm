package niuke.dp;

/**
 * @description: 打家劫舍(一)
 * @author: lzy
 * @time: 2024/8/14 7:07
 * dp[i][0]表示偷当前位置的房屋所能获得的最大金额
 * dp[i][1]表示不偷当前位置的房屋所能获得的最大金额
 */
public class BM78 {
    public int rob (int[] nums) {
        // write code here
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][1] + nums[i];
            dp[i][1] = Math.max(dp[i-1][0],dp[i-1][1]);
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);
    }
}
