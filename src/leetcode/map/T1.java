package leetcode.map;

import java.util.HashMap;
import java.util.Map;

public class T1 {
    public static void main(String[] args) {
        int[] array = {1,2,7,8};
        int target = 9;
        Solution solution = new Solution();
        int[] ints = solution.twoSum(array, target);
        for (int i : ints) {
            System.out.print(i + " ");
        }

    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                break;
            }
            map.put(nums[i],i);
        }
        return res;
    }
}
