package niuke.doublePointers;

/**
 * @description:大数加法：双指针模拟
 * @author: lzy
 * @time: 2024/8/11 14:30
 */
public class BM86 {
    public String solve(String s, String t) {
        // write code here
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1, j = t.length() - 1;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int x = s.charAt(i) - '0';
            int y = t.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
            i -= 1;
            j -= 1;
        }
        while (i >= 0) {
            int x = s.charAt(i) - '0';
            sb.append((x + carry) % 10);
            carry = (x + carry) / 10;
            i -= 1;
        }
        while (j >= 0) {
            int y = t.charAt(j) - '0';
            sb.append((y + carry) % 10);
            carry = (y + carry) / 10;
            j -= 1;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
