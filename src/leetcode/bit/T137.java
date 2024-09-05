package leetcode.bit;

/**
 * @description: 只出现一次的数字Ⅱ
 * @author: lzy
 * 遍历每个数字的二进制位，如果某一位上1的个数不是3的倍数，说明这一位属于只出现一次的那个数字
 * @time: 2024/9/5 15:36
 */
public class T137 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int cnt = 0;
            for (int num : nums) {
                cnt += (num >> i) & 1;
            }
            if (cnt % 3 != 0) {
                res |= (1 << i);
            }
        }
        return res;
    }
}
