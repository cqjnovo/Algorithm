package leetcode;

import java.util.HashMap;
import java.util.Map;

public class T220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        Map<Long,Long> map = new HashMap<>();
        long w = (long) valueDiff + 1;
        for (int i = 0; i < nums.length; i++) {
            long id = getId(nums[i],w);
            if (map.containsKey(id)) {
                return true;
            }
            if (map.containsKey(id - 1) && Math.abs(map.get(id - 1) - nums[i]) < w) {
                return true;
            }
            if (map.containsKey(id + 1) && Math.abs(map.get(id + 1) - nums[i]) < w) {
                return true;
            }
            map.put(id,(long)nums[i]);
            if (i >= indexDiff) {
                map.remove(getId(nums[i-indexDiff],w));
            }
        }
        return false;
    }

    public long getId(long x, long w) {
        if (x >= 0) {
            return x / w;
        }
        return (x + 1) / w - 1;
    }
}
