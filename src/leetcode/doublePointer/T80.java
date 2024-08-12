package leetcode.doublePointer;

public class T80 {
    public int removeDuplicates(int[] nums) {
        int l = 0, r = 0;
        int n = nums.length;
        int cur = 0;
        while (l < n) {
            if (r < n && nums[r] == nums[l]) {
                r += 1;
            } else {
                int temp = cur + Math.min(r-l,2);
                while (cur < temp) {
                    nums[cur] = nums[l];
                    cur += 1;
                }
                l = r;
            }
        }
        return cur;
    }
}
