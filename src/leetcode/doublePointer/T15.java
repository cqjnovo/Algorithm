package leetcode.doublePointer;

import java.util.*;

/**
 * @description: 三数之和
 * @author: lzy
 * @time: 2024/8/22 19:24
 */
public class T15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        //固定一个数，另外两个数使用双指针遍历
        for (int i = 0; i < n; i++) {
            //如果最小的一个数都已经大于0，说明后序不再有可行解，提前返回
            if (nums[i] > 0) {
                return res;
            }
            //对第一个数去重
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            while (right > left) {
                int temp = nums[i] + nums[left] + nums[right];
                if (temp > 0) {
                    right -= 1;
                } else if (temp < 0) {
                    left += 1;
                } else {
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //分别对left,right去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left += 1;
                    }
                    while (right > left && nums[right] == nums[right - 1]) {
                        right -= 1;
                    }
                    left += 1;
                    right -= 1;
                }
            }
        }
        return res;
    }
}
