package leetcode.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description:
 * @author: lzy
 * @time: 2024/9/4 9:01
 */
public class T2860 {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int n = nums.size();
        int ans = 0;
        if (nums.get(0) > 0) {
            ans += 1;
        }
        if (nums.get(n-1) < n) {
            ans += 1;
        }
        for (int i = 0; i < n - 1; i++) {
            if (i + 1 > nums.get(i) && i + 1 < nums.get(i+1)) {
                ans += 1;
            }
        }
        return ans;
    }
}
