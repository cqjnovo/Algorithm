package leetcode;

/**
 * @description:求出最长回文子串，返回该子串
 * @author: lzy
 * @time: 2024/8/9 9:45
 */
public class T5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 0;
        int start = 0;
        //dp[i][j]用于标记从i到j的子串是否为回文串
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1 || dp[i+1][j-1] == true) {
                        dp[i][j] = true;
                        if (j - i + 1 > maxLen) {
                            maxLen = Math.max(maxLen,j-i+1);
                            start = i;
                        }
                    }
                }
            }
        }
        return s.substring(start,start+maxLen);
    }
}
