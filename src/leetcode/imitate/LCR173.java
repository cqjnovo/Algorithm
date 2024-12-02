package leetcode.imitate;

/**
 * @description:
 * @author: lzy
 * @time: 2024/12/2 17:04
 */
public class LCR173 {
    public int takeAttendance(int[] records) {
        if (records[0] == 1) {
            return 0;
        }
        int i = 0;
        while (i < records.length - 1) {
            if (records[i] + 1 == records[i+1]) {
                i += 1;
            } else {
                break;
            }
        }
        return records[i] + 1;
    }
}
