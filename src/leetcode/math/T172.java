package leetcode.math;

/**
 * @description: 阶乘后的零
 * @author: lzy
 * @time: 2024/9/16 10:15
 */
public class T172 {
    public int trailingZeroes(int n) {
        int cnt = 0;
        for (int i = 5; i <= n; i += 5) {
            int temp = i;
            while (temp % 5 == 0) {
                temp /= 5;
                cnt += 1;
            }
        }
        return cnt;
    }

    //优化 O(log5(n))
    public int trailingZeroes_1(int n) {
        int cnt = 0;
        for (int x = n / 5; x > 0; x /= 5) {
            cnt += x;
        }
        return cnt;
    }
}
