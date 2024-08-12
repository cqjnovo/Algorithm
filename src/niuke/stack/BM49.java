package niuke.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BM49 {


    public static void main(String[] args) {
        String s = "1+(-2)*(-3)";
        BM49 bm49 = new BM49();
        System.out.println(bm49.solve(s));
    }
    public int solve (String s) {
        //定义一个hashMap保存运算符的优先级
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        map.put('+',1);
        map.put('-',1);
        map.put('*',2);
        //使用两个栈：运算符栈和操作数栈
        Stack<Character> opts = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        //防止读取到负号时，栈中只有一个操作数
        nums.push(0);
        char[] charArray = s.toCharArray();
        int i = 0;
        while (i < charArray.length) {
            char c = charArray[i];
            //左括号直接入运算符栈
            if (c == '(') {
                opts.push(c);
            } else if (c == ')') { //右括号直到弹出匹配的左括号才结束
                while (opts.peek() != '(') {
                    calculate(opts,nums);
                }
                opts.pop();
            } else if (Character.isDigit(c)) { //计算出连续数字对应的整数并入操作数栈
                int num = 0;
                while (i < charArray.length && Character.isDigit(charArray[i])) {
                    num = num * 10 + (charArray[i] - '0');
                    i += 1;
                }
                i -= 1;
                nums.push(num);
            } else { //运算符需要根据优先级决定计算方式
                //如果当前操作符前是'('，表示当前操作符为‘-’，需要特殊处理
                if (i > 0 && charArray[i-1] == '(') {
                    nums.push(0);
                }
                int priority = map.get(c);
                while (!opts.isEmpty() && opts.peek() != '(' && priority <= map.get(opts.peek())) {
                    calculate(opts,nums);
                }
                opts.push(c);
            }
            i += 1;
        }
        while (!opts.isEmpty()) {
            calculate(opts,nums);
        }
        return nums.pop();
    }

    public void calculate(Stack<Character> opts, Stack<Integer> nums) {
        if (opts.size() < 1 || nums.size() < 2) return;
        char operator = opts.pop();
        int m = nums.pop();
        int n = nums.pop();
        int res = 0;
        if (operator == '+') {
            res = n + m;
        } else if (operator == '-') {
            res = n - m;
        } else {
            res = n * m;
        }
        nums.push(res);
    }
}
