package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description:零钱兑换（完全背包:先物品再背包容量）
 * @author: lzy
 * @time: 2024/8/9 9:16
 */
public class T322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j],dp[j-coins[i]] + 1);
            }
        }
        if (dp[amount] < Integer.MAX_VALUE / 2) {
            return dp[amount];
        }
        return -1;
    }
}
