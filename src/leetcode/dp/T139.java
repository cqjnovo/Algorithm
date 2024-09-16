package leetcode.dp;

import java.util.HashSet;
import java.util.List;

/**
 * @description: 单词拆分
 * 完全背包
 * @author: lzy
 * @time: 2024/9/16 9:33
 */
public class T139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        //想象使用大小为s.length()的背包，能否使用wordDict中的物品完全填满
        int n = s.length();
        HashSet<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String subString = s.substring(j,i);
                if (dp[j] && wordSet.contains(subString)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
