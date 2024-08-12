package leetcode.stack;

import java.util.Stack;

/**
 * @description:LeetCode224-基本计算器:实现基础的加减功能 s = "(1+(4+5+2)-3)+(6+8)" res = 23
 * @author: lzy
 * @time: 2024/8/7 11:05
 */
public class T224 {
    public static void main(String[] args) {
        String s = "2-(5-6)";
        System.out.println(new T224().calculate(s));
    }
    public int calculate(String s) {
        s.replace(" ","");
        //定义操作数栈和运算符栈
        Stack<Character> opts = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        nums.push(0);
        char[] charArray = s.toCharArray();
        int i = 0;
        while (i < charArray.length) {
            char c = charArray[i];
            if (c == ' ') {
                i += 1;
                continue;
            } else if (c == '(') {
                opts.push(c);
            } else if (c == ')') {
                //直到匹配左括号，弹出之间所有的运算符
                while (!opts.isEmpty() && opts.peek() != '(') {
                    compute(opts,nums);
                }
                opts.pop();
            } else if (c == '+' || c == '-') {
                if (i > 0 && charArray[i-1] == '(' && c == '-') {
                    nums.push(0);
                }
                while (!opts.isEmpty() && opts.peek() != '(') {
                    compute(opts, nums);
                }
                opts.push(c);
            } else {
                int num = 0;
                while (i < charArray.length && Character.isDigit(charArray[i])) {
                    num = num * 10 + charArray[i] - '0';
                    i += 1;
                }
                nums.push(num);
                i -= 1;
            }
            i += 1;
        }
        while (!opts.isEmpty()) {
            compute(opts,nums);
        }
        return nums.pop();
    }

    public void compute(Stack<Character> opts, Stack<Integer> nums) {
        if (opts.size() < 1 || nums.size() < 2) {
            return;
        }
        Character opt = opts.pop();
        Integer r = nums.pop();
        Integer l = nums.pop();
        int res = 0;
        if (opt == '+') {
            res = l + r;
        } else {
            res = l - r;
        }
        nums.push(res);
    }
}
