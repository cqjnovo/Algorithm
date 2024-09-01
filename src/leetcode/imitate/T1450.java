package leetcode.imitate;

/**
 * @description: 在既定时间做作业的学生人数
 * @author: lzy
 * @time: 2024/9/1 19:31
 */
public class T1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int n = startTime.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                cnt += 1;
            }
        }
        return cnt;
    }
}
