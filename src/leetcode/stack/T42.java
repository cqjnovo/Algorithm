package leetcode.stack;

import java.util.Stack;

/**
 * @description: 接雨水、
 * 1.当遇到右边第一个比当前元素大的元素时，需要弹出此时的栈顶元素作为中间位置
 * 2.弹出栈顶元素后，此刻的栈顶位置即为中间位置左边第一个比它高的位置
 * 3.另外，当前遍历到的元素即为右边第一个比当前元素大的位置。
 * 通过左右两个位置之间的坐标距离和最小高度差，即可求出当前位置所能接住的雨水面积
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
