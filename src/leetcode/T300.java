package leetcode;

import java.util.Arrays;

/**
 * @description: 最长递增子序列
 * @author: lzy
 * @time: 2024/8/11 15:50
 */
public class T300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int res = 1;
        Arrays.fill(dp,1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                    if (dp[i] > res) {
                        res = dp[i];
                    }
                }
            }
        }
        return res;
    }
}
