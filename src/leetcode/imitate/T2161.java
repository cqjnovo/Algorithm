package leetcode.imitate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 根据给定数字划分数组
 * @author: lzy
 * @time: 2024/8/24 8:45
 */
public class T2161 {
    /**
     * 方法一：三个list分别存放<,=,> pivot的元素
     * @param nums
     * @param pivot
     * @return
     */
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> lt = new ArrayList<>();
        List<Integer> eq = new ArrayList<>();
        List<Integer> gt = new ArrayList<>();
        for (int num : nums) {
            if (num < pivot) {
                lt.add(num);
            } else if (num == pivot) {
                eq.add(num);
            } else {
                gt.add(num);
            }
        }
        lt.addAll(eq);
        lt.addAll(gt);
        return lt.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 双指针
     * @param nums
     * @param pivot
     * @return
     */
    public int[] pivotArray1(int[] nums, int pivot) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res,pivot);
        int left = 0, right = n - 1;
        //左指针找比pivot小的元素,右指针找比pivot大的元素
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                res[left++] = nums[i];
            } else if (nums[i] > pivot) {
                res[right--] = nums[i];
            }
        }
        //右指针对应区域逆序
        left = right + 1;
        right = n - 1;
        while (left < right) {
            int temp = res[left];
            res[left] = res[right];
            res[right] = temp;
            left += 1;
            right -= 1;
        }
        return res;
    }
}
