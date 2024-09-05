package leetcode.imitate;

import java.util.Arrays;

/**
 * @description:
 * @author: lzy
 * @time: 2024/9/5 9:45
 */
public class T3174 {
    public static void main(String[] args) {
        T3174 solution = new T3174();
        System.out.println(solution.clearDigits("aac34"));
    }
    public String clearDigits(String s) {
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) && cnt > 0) {
                cnt -= 1;
                sb.deleteCharAt(cnt);
            } else {
                sb.append(c);
                cnt += 1;
            }
        }
        return sb.toString();
    }

}
