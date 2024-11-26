package leetcode.prefix;

/**
 * @description: 特殊数组Ⅱ
 * 求所给的查询区间对应的子数组是否每一对相邻元素都是奇偶性不同的
 * @author: lzy
 * @time: 2024/11/26 9:52
 */
public class T3152 {
    /**
     * nums = [4,3,1,6], queries = [[0,2],[2,3]]
     * flags = [0,1,0],  prefix = [0,0,1,1]
     * [0,2] -> prefix[2] - prefix[0] = 1 - 0 = 1  false
     * test amend
     * @param nums
     * @param queries
     * @return
     */
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        boolean[] res = new boolean[queries.length];
        //pre[f,t] = pre[t] - pre[f] != 0 说明这个子数组不是特殊数组
        int[] pre = new int[n];
        for (int i = 1; i < n; i++) {
            if (nums[i] % 2 == nums[i-1] % 2) {
                pre[i] = pre[i-1] + 1;
            } else {
                pre[i] = pre[i-1];
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int f = queries[i][0], t = queries[i][1];
            res[i] = pre[t] == pre[f];
        }
        return res;
    }
}
