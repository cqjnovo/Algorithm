package niuke.dp;

/**
 * @description: 编辑距离
 * @author: lzy
 * @time: 2024/8/19 18:45
 */
public class BM75 {
    public int editDistance (String str1, String str2) {
        // write code here
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m+1][n+1];
        //dp[i][j]表示以str1[i-1]为结尾的子串和以str2[j-1]为结尾的子串相同时最小的操作次数
        //初始化第0行和第0列
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    //否则，可以通过添加/删除或者替换的方式使得这两个位置处的字符相等
                    //但是 添加和删除是一组可逆的操作，在word1中删除 等价与 在word2中添加
                    int temp = Math.min(dp[i-1][j],dp[i][j-1]);
                    dp[i][j] = Math.min(temp,dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
