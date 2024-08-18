package review.shenxinfu;

import java.util.Scanner;

/**
 * @description: T1机器人捡豆豆
 * @author: lzy
 * @time: 2024/8/18 19:32
 * TODO:(仅通过部分样例，存在问题待查找)
 */
public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String operators = in.nextLine();
        char[] chars = line.toCharArray();
        char[] opts = operators.toCharArray();
        int res = getMaxLong(opts, chars);
        System.out.println(res);
    }

    public static int getMaxLong(char[] opts, char[] x) {
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < opts.length && j < x.length) {
            if (opts[i] == x[j]) {
                i += 1;
                j += 1;
                res += 1;
            } else if (opts[i] == '*') {
                char c = ' ';
                if (i > 0) {
                    c = opts[i - 1];
                } else {
                    i += 1;
                    continue;
                }
                while (x[j] == c) {
                    j += 1;
                    res += 1;
                }
                i += 1;
            } else {
                break;
            }
        }
        return res;
    }
}
