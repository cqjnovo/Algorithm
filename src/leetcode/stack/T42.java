package leetcode.stack;

import java.util.Stack;

/**
 * @description: 接雨水
 * @author: lzy
 * @time: 2024/11/11 10:24
 */
public class T42 {
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        for (int i = 1; i < n; i++) {
            //如果当前高度小于等于栈顶元素，直接入栈
            if (height[i] <= height[stack.peek()]) {
                stack.add(i);
            } else {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    //否则，令当前栈顶元素为中间值，分别找它左右第一个比它大的位置
                    int mid = stack.pop();
                    int h = 0;
                    int w = 0;
                    if (!stack.isEmpty()) {
                        h = Math.min(height[stack.peek()],height[i]) - height[mid];
                        w = i - stack.peek() - 1;
                    }
                    res += h * w;
                }
                stack.add(i);
            }
        }
        return res;
    }
}
