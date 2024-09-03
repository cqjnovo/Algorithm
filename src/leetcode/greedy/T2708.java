package leetcode.greedy;

import java.util.Arrays;

/**
 * @description: 一个小组的最大实力值
 * @author: lzy
 * @time: 2024/9/3 9:19
 */
public class T2708 {
    public long maxStrength(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        //如果负数有奇数个，从小到大取不超过该奇数的最大偶数个
        int i = 0;
        long res = 1;
        while (i < nums.length) {
            if (nums[i] < 0) {
                res *= nums[i];
                i += 1;
            } else {
                break;
            }
        }
        //只有1个以下的负数，且nums最大值为0，所能得到的能量值就是0
        if (i <= 1 && nums[nums.length-1] == 0) {
            return 0l;
        }
        //有奇数个负数，需要将最后一个负数除去
        if (i % 2 == 1) {
            res /= nums[i-1];
        }
        //取所有的正数的乘积
        while (i < nums.length) {
            if (nums[i] > 0) {
                res *= nums[i];
            }
            i += 1;
        }
        return res;
    }
}
