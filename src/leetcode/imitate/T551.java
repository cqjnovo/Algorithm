package leetcode.imitate;

/**
 * @description: 学生出勤记录Ⅰ
 * @author: lzy
 * @time: 2024/8/18 14:44
 * 不能有连续的3天L,总的A小于2
 */
public class T551 {
    public boolean checkRecord(String s) {
        char[] array = s.toCharArray();
        int cntA = 0;
        int i = 0;
        while(i < array.length) {
            if (array[i] == 'A') {
                cntA += 1;
            } else if (array[i] == 'L') {
                int cntL = 1;
                int j = i + 1;
                while (j < array.length && array[j] == 'L') {
                    cntL += 1;
                    j += 1;
                }
                if (cntL >= 3) {
                    return false;
                }
                i = j;
                continue;
            }
            i += 1;
        }
        return cntA < 2;
    }
}
