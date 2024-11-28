package leetcode.doublePointer;

/**
 * @description: 长度为k的子数组的能量值Ⅰ,Ⅱ
 * @author: lzy
 * @time: 2024/11/28 10:29
 */
public class T3254 {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int l = k - 1, r = k - 1;
        //初始化l的位置,保证l到r是一段连续的区间
        while (l > 0) {
            if (nums[l] - nums[l-1] == 1) {
                l -= 1;
            } else {
                break;
            }
        }
        while (r < n) {
            //因为r初始化为k-1,所以从循环开始，只需要判断r-l这段连续区间的长度是否>=k即可
            if (r - l + 1 >= k) {
                //如果连续区间长度>=k 直接将当前r所在位置的元素定义为当前长度为k的子数组的能量值
                res[r-k+1] = nums[r];
            } else {
                //否则，说明连续数组的长度不足k个，直接将-1定义为这个子数组的能量值
                res[r-k+1] = -1;
            }
            //r继续向后移动
            r += 1;
            //移动后，需要根据下标r和r-1的关系，判断新加入区间的元素是否仍能保持连续
            //一旦不再连续，就需要更新连续区间的左端点l=r
            if (r < n && nums[r] - nums[r-1] != 1) {
                l = r;
            }
        }
        return res;
    }
}
