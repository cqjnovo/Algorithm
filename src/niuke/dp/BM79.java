package niuke.dp;

import java.util.Arrays;

/**
 * @description: 打家劫舍(二)
 * @author: lzy
 * @time: 2024/8/14 7:43
 * 循环数组，最后一个位置的下一个位置为首个位置
 */
public class BM79 {
    public int rob (int[] nums) {
        // write code here
        int n = nums.length;
        //为了拆分环形数组，分两种情况
        //如果从第0间开始，最后一间一定不能偷，则就是[0,n-2]的范围内的打家劫舍(一)
        //如果从第1间开始，最后一间可以偷，则就是[1,n-1]范围内的打家劫舍(一)
        return Math.max(getMax(Arrays.copyOfRange(nums,0,n-1)),getMax(Arrays.copyOfRange(nums,1,n)));
    }
    public int getMax(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        for(int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][1] + nums[i];
            dp[i][1] = Math.max(dp[i-1][0],dp[i-1][1]);
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);
    }
}
