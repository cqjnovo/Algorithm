package leetcode.doublePointer;

/**
 * @description: 交替组Ⅱ
 * @author: lzy
 * 对于环形数组问题，为了方便处理，直接将原数组在后面拼接一份，并且在i>=n的才开始计数，防止重复统计
 * @time: 2024/11/27 10:23
 */
public class T3208 {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int res = 0, cnt = 0, n = colors.length;
        for (int i = 0; i < 2 * n; i++) {
            if (i > 0 && colors[i%n] == colors[(i-1) % n]) {
                cnt = 0;
            }
            cnt += 1;
            if (i >= n && cnt >= k) {
                res += 1;
            }
        }
        return res;
    }
}
