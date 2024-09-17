package leetcode.bit;

/**
 * @description:
 * 从最高位开始，依次向后找left,right的公共前缀
 * @author: lzy
 * @time: 2024/9/17 8:07
 */
public class T201 {
    //1000 1001 1010 1011 1100 1101 1110 1111
    public int rangeBitwiseAnd(int left, int right) {
        int mask = 1 << 30;
        int res = 0;
        while (mask > 0 && ((mask & left) == (mask & right))) {
            res |= (mask & left);
            mask >>= 1;
        }
        return res;
    }
}
