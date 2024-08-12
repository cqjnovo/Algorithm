package leetcode.dp;

import java.util.Arrays;

/**
 * @description:最长连续递增子序列-单层循环
 * @author: lzy
 * @time: 2024/8/11 16:17
 */
public class T674 {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int res = 1;
        Arrays.fill(dp,1);
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i-1]) {
                dp[i] = dp[i-1] + 1;
                if (dp[i] > res) {
                    res = dp[i];
                }
            }
        }
        return res;
    }
}
