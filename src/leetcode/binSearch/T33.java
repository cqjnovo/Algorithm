package leetcode.binSearch;

/**
 * @description: 搜索旋转排序数组
 * @author: lzy
 * @time: 2024/8/30 10:21
 */
public class T33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            //因为[l,mid] , [mid,r]两个区间只有可能有一个是有序的
            //如果左区间有序
            if (nums[l] <= nums[mid]) {
                //target位于左区间中，就到左区间寻找
                if (target >= nums[l] && target <= nums[mid]) {
                    r = mid - 1;
                } else { // 否则就去右区间寻找
                    l = mid + 1;
                }
            } else { //反之，右区间有序
                //如果target位于右区间，就到右区间寻找
                if (target >= nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else {  // 否则就到左区间寻找
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
