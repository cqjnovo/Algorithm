package leetcode.doublePointer;

/**
 * @description: 最大连续1的个数 Ⅲ
 * @author: lzy
 * @time: 2024/9/2 15:50
 */
public class T1004 {
    public int longestOnes(int[] nums, int k) {
        int cnt = 0;
        int res = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                cnt += 1;
            }
            while (cnt > k) {
                if (nums[l] == 0) {
                    cnt -= 1;
                }
                l += 1;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
