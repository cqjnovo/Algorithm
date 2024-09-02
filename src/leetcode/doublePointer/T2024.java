package leetcode.doublePointer;

/**
 * @description: 考试的最大困扰度
 * @author: lzy
 * @time: 2024/9/2 15:29
 * 在最多操作k次的前提下，求所能得到的最长连续T/F的长度
 */
public class T2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int cnt_t = 0, cnt_f = 0;
        int res = 0;
        int l = 0;
        for (int r = 0; r < answerKey.length(); r++) {
            if (answerKey.charAt(r) == 'T') {
                cnt_t += 1;
            } else {
                cnt_f += 1;
            }
            while (cnt_t > k && cnt_f > k) {
                if (answerKey.charAt(l) == 'T') {
                    cnt_t -= 1;
                } else {
                    cnt_f -= 1;
                }
                l += 1;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
