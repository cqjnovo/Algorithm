package leetcode.doublePointer;

/**
 * @description: 有序数组的平方
 * @author: lzy
 * @time: 2024/9/10 17:01
 */
public class T977 {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int cnt = n - 1;
        int left = 0, right = n - 1;
        while (left <= right) {
            if (Math.abs(nums[left]) >= Math.abs(nums[right])) {
                res[cnt--] = nums[left] * nums[left];
                left += 1;
            } else {
                res[cnt--] = nums[right] * nums[right];
                right -= 1;
            }
        }
        return res;
    }
}
