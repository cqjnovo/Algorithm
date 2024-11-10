package leetcode.hashSet;

import java.util.HashSet;
import java.util.Optional;

/**
 * @description: 找出有序数组中的单一元素
 * @author: lzy
 * @time: 2024/11/10 18:40
 */
public class T540 {
    //解法1：判断相邻两个元素是否相等
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0;
        while (l < n - 1) {
            if (nums[l] == nums[l+1]) {
                l += 2;
            } else {
                break;
            }
        }
        return nums[l+1];
    }


    //解法2：使用hashSet,重复元素从集合中弹出，最后剩的就是单个
    public int singleNonDuplicate2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        int res = 0;
        for (Integer a : set) {
            res = a;
        }
        return res;
    }

    //解法3：二分查找，寻找打破规律的第一个位置
    public int singleNonDuplicate3(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            //如果mid是偶数下标，那么就判断它是否和右边的数相等，如果相等说明它及其前面的偶数对都是成对出现的
            //如果mid是奇数下标，那么就判断它是否和左边的数相等，如果相等说明它及其前面的偶数对都是成对出现的
            if ((mid % 2 == 0 && nums[mid] == nums[mid+1]) || (mid % 2 == 1 && nums[mid] == nums[mid-1])) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}
