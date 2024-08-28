package leetcode.imitate;

/**
 * @description: x的平方根
 * @author: lzy
 * @time: 2024/8/28 11:26
 */
public class T69 {
    public int mySqrt(int x) {
        long l = 0, r = x;
        while (l < r) {
            long mid = l + (r - l) / 2 + 1;
            if (mid * mid <= x) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return (int)l;
    }
}
