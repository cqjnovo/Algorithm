package leetcode.slidingWindow;

import java.util.HashSet;

/**
 * @description: 无重复字符的最长子串
 * 当右指针指向的元素已经在窗口中存在时，就不断弹出左指针对应的元素，直到与右指针相同的元素被弹出为止
 * @author: lzy
 * @time: 2024/9/13 9:47
 */
public class T3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        boolean[] flag = new boolean[128];
        int left = 0, right = 0;
        int res = 0;
        while (right < n) {
            char c = s.charAt(right);
            if (!flag[c]) {
                flag[c] = true;
                res = Math.max(res, right - left + 1);
                right += 1;
            } else {
                while (flag[c]) {
                    flag[s.charAt(left)] = false;
                    left += 1;
                }
            }
        }
        return res;
    }
}
