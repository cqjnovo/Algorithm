package leetcode;

public class T283 {
    public void moveZeroes(int[] nums) {
        int l = 0, r = 0, n = nums.length;
        while (r < n) {
            if (nums[r] != 0) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l += 1;
            }
            r += 1;
        }
    }
}
