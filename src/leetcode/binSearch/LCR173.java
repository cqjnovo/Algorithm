package leetcode.binSearch;

/**
 * @description:
 * @author: lzy
 * @time: 2024/12/2 17:04
 */
public class LCR173 {
    public int takeAttendance(int[] records) {
        int l = 0, r = records.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (records[mid] != mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r == records.length - 1 && records[r] == r ? r + 1 : r;
    }
}
