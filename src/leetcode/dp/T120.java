package leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 三角形最小路径和
 * @author: lzy
 * @time: 2024/9/1 20:15
 */
public class T120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE / 2);
        }
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1]) + triangle.get(i).get(j);
            }
        }
        int res = Integer.MAX_VALUE / 2;
        for (int j = 0; j < m; j++) {
            if (dp[m-1][j] < res) {
                res = dp[m-1][j];
            }
        }
        return res;
    }
}
