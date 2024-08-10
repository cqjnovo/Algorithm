package leetcode;

/**
 * @description: 反转字符串中的单词
 * s = "sky is blue" -> "blue is sky"
 * @author: lzy
 * @time: 2024/8/10 9:25
 */
public class T151 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int j = s.length() - 1;
        int i = 0;
        while (j >= 0) {
            if (s.charAt(j) != ' ') {
                i = j;
                while (i >= 0 && s.charAt(i) != ' ') {
                    i -= 1;
                }
                sb.append(s.substring(i+1,j+1) + " ");
                j = i;
            } else {
                j -= 1;
            }
        }
        return sb.toString().strip();
    }
}
