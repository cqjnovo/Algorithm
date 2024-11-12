package leetcode.imitate;

/**
 * @description: 求满足子串中0/1的个数小于k个的所有子串数目
 * @author: lzy
 * @time: 2024/11/12 8:40
 */
public class T3258 {
    /**
     * 解法1：模拟
     * @param s
     * @param k
     * @return
     */
    public int countKConstraintSubstrings_1(String s, int k) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int cnt_zero = 0, cnt_one = 0;
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == '0') {
                    cnt_zero += 1;
                } else {
                    cnt_one += 1;
                }
                if (cnt_one > k && cnt_zero > k) {
                    break;
                } else {
                    res += 1;
                }
            }
        }
        return res;
    }

    /**
     * 解法2：双指针
     * @param s
     * @param k
     * @return
     */
    public int countKConstraintSubstrings(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int l = 0, r = 0;
        int cnt_0 = 0, cnt_1 = 0;
        int res = 0;
        while (r < n) {
            if (chars[r] == '0') {
                cnt_0 += 1;
            } else {
                cnt_1 += 1;
            }
            while (cnt_1 > k && cnt_0 > k) {
                if (chars[l] == '0') {
                    cnt_0 -= 1;
                } else {
                    cnt_1 -= 1;
                }
                l += 1;
            }
            res += (r - l + 1);
            r += 1;
        }
        return res;
    }
}

