package leetcode.stack;

import java.util.Stack;

/**
 * @description:
 * @author: lzy
 * @time: 2024/11/11 9:01
 */
public class T739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        //单调栈中存储元素下标，如果当前元素大于栈顶元素，令栈顶元素ans[idx] = cur
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || temperatures[i] <= temperatures[stack.peek()]) {
                stack.add(i);
                continue;
            }
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                ans[idx] = i - idx;
            }
            stack.add(i);
        }
        return ans;
    }
}
