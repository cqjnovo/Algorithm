package leetcode.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * @description: 柱状图中的最大矩形面积
 * @author: lzy
 * @time: 2024/11/12 10:18
 */
public class T84 {
    /**
     * 接雨水的逆过程
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        //数组首位添加0,防止空栈
        int[] temp = new int[heights.length + 2];
        System.arraycopy(heights,0,temp,1,heights.length);
        heights = temp;
        Stack<Integer> st = new Stack<>();
        st.add(0);
        int ans = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] >= heights[st.peek()]) {
                st.add(i);
            } else {
                while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                    //弹出栈顶元素作为此矩形的高 -- 基准
                    int mid = st.pop();
                    int h = heights[mid];
                    int w = 0;
                    if (!st.isEmpty()) {
                        w = i - st.peek() - 1;
                        ans = Math.max(ans, h * w);
                    }
                }
                st.add(i);
            }
        }
        return ans;
    }
}
