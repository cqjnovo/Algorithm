package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class T150 {
    public static void main(String[] args) {
        String[] tokens = new String[] {"2","1","+","3","*"};
        System.out.println(new T150().evalRPN(tokens));
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String cur = tokens[i];
            if (cur.equals("+") || cur.equals("-") || cur.equals("*") || cur.equals("/")) {
                int r = numbers.pop();
                int l = numbers.pop();
                if (cur.equals("+")) {
                    numbers.push(l + r);
                } else if (cur.equals("-")) {
                    numbers.push(l - r);
                } else if (cur.equals("*")) {
                    numbers.push(l * r);
                } else {
                    numbers.push(l / r);
                }
            } else {
                numbers.push(Integer.parseInt(cur));
            }
        }
        return numbers.pop();
    }

}
