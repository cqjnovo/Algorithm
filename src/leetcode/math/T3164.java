package leetcode.math;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @description:
 * @author: lzy
 * @time: 2024/10/11 10:28
 */
public class T3164 {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        //遍历nums1中的所有数字，求出它包含在nums2中的所有因数有多少个
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums2) {
            if (map.containsKey(num * k)) {
                map.put(num * k, map.get(num * k) + 1);
            } else {
                map.put(num * k, 1);
            }
        }
        for (int num : nums1) {
            int i = 1;
            while (i * i <= num) {
                if (num % i == 0) {
                    int j = num / i;
                    if (map.containsKey(i)) {
                        ans += map.get(i);
                    }
                    if (i != j && map.containsKey(j)) {
                        ans += map.get(j);
                    }
                }
                i += 1;
            }
        }
        return ans;
    }
}
