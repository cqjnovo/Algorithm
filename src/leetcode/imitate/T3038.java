package leetcode.imitate;

/**
 * @description:
 * @author: lzy
 * @time: 2024/9/17 8:56
 */
public class T3038 {
    public int maxOperations(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return 0;
        }
        int res = 1;
        int cnt = nums[0] + nums[1];
        int i = 2;
        while (i < n - 1 && nums[i] + nums[i+1] == cnt) {
            i += 2;
            res += 1;
        }
        return res;
    }
}
