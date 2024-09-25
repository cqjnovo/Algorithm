package leetcode.greedy;

/**
 * @description: 2207.字符串中最多数目的子序列
 * @author: lzy
 * @time: 2024/9/25 15:58
 */
public class T2207 {
    public long maximumSubsequenceCount(String text, String pattern) {
        char x = pattern.charAt(0), y = pattern.charAt(1);
        int cnt_x = 0, cnt_y = 0, ans = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == y) {
                ans += cnt_x;
                cnt_y += 1;
            }
            if (text.charAt(i) == x) {
                cnt_x += 1;
            }
        }
        return ans + Math.max(cnt_x,cnt_y);
    }
}
