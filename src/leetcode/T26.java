package leetcode;

public class T26 {
    //双指针删除数组中重复元素
    public int removeDuplicates(int[] nums) {
        int left = 0, right = 0;
        int n = nums.length;
        int cur = 0;
        while (left < n) {
            if (right < n && nums[right] == nums[left]) {
                right += 1;
            } else {
                nums[cur] = nums[left];
                cur += 1;
                left = right;
            }
        }
        return cur;
    }
}
