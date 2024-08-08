package niuke;

/**
 * @description:
 * @author: lzy
 * @time: 2024/8/8 18:49
 */
public class BM73 {
    public int getLongestPalindrome (String A) {
        // write code here
        int n = A.length();
        boolean[][] dp = new boolean[n][n];
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (A.charAt(i) == A.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        res = Math.max(res,j-i+1);
                    } else if (dp[i+1][j-1] == true) {
                        dp[i][j] = true;
                        res = Math.max(res,j-i+1);
                    }
                }
            }
        }
        return res;
    }
}
