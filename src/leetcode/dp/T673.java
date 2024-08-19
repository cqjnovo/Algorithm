package leetcode.dp;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description: 最长递增子序列的个数
 * @author: lzy
 * @time: 2024/8/13 20:44
 * input: [1,3,5,4,7]
 * output: 2
 */
public class T673 {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int res = 0;
        int max = 0;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for (int i = 0; i < n; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxVal = Math.max(maxVal,dp[j]);
                }
            }
            dp[i] = maxVal + 1;
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) {
                res += 1;
            }
        }
        return res;
    }
}
