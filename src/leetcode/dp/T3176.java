package leetcode.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 求出最长好子序列 I
 * @author: lzy
 * @time: 2024/9/6 10:51
 */
public class T3176 {
    public int maximumLength(int[] nums, int k) {
        //dp[i][j]表示以nums[i]为结尾元素，且存在至多k对相邻位置不相等的下标时最长的子序列长度
        int ans = 0;
        int len = nums.length;
        int[][] dp = new int[len][51];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < len; i++) {
            dp[i][0] = 1;
            //枚举k对不相等相邻元素情况
            for (int l = 0; l <= k; l++) {
                //向前找，如果当前位置元素与前面元素不同，需要消耗一次不相等的元素对数
                for (int j = 0; j < i; j++) {
                    int add = nums[i] != nums[j] ? 1 : 0;
                    if (l - add >= 0 && dp[j][l - add] != -1) {
                        dp[i][l] = Math.max(dp[i][l], dp[j][l - add] + 1);
                    }
                }
                ans = Math.max(ans, dp[i][l]);
            }
        }
        return ans;
    }
}
