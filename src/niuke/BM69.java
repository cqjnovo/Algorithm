package niuke;

import java.util.Arrays;

/**
 * @description: 把数字翻译成字符串
 * @author: lzy
 * @time: 2024/8/12 9:27
 */
public class BM69 {
    /**
     * 1->a 2->b ... 26->z
     * @param nums
     * @return
     */
    public int solve (String nums) {
        // write code here
        int n = nums.length();
        //初始化
        int[] dp = new int[n];
        if (nums.charAt(0) - '0' == 0) {
            dp[0] = 0;
        } else {
            dp[0] = 1;
        }
        for (int i = 1; i < n; i++) {
            int cnt = 0;
            int cur = nums.charAt(i) - '0';
            if (cur != 0) {
                cnt += 1;
            }
            int pre = Integer.parseInt(nums.substring(i - 1, i + 1));
            if (pre >= 1 && pre <= 26 && cur != pre) {
                cnt += 1;
            }
            if (i == 1 || cnt == 0) {
                dp[i] = cnt;
            } else if (cnt == 1){
                dp[i] = dp[i-1];
            } else {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n - 1];
    }
}
