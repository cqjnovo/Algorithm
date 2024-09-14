package leetcode.stack;

import java.util.Stack;

/**
 * @description:
 * @author: lzy
 * @time: 2024/9/14 14:50
 */
public class T2390 {
    /**
     * 栈
     * @param s
     * @return
     */
    public String removeStars(String s) {
        //遇到字符就入栈，遇到*就弹出栈顶元素
        Stack<Character> stack = new Stack<>();
        int i = 0;
        int n = s.length();
        while (i < n) {
            char c = s.charAt(i);
            if (c == '*') {
                stack.pop();
            } else {
                stack.push(c);
            }
            i += 1;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    /**
     * 模拟
     * @param s
     * @return
     */
    public String removeStars_1(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*') {
                stringBuilder.append(s.charAt(i));
            } else {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
        return stringBuilder.toString();
    }
}
