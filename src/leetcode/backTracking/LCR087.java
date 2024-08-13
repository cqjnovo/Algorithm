package leetcode.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:复原IP地址
 * @author: lzy
 * @time: 2024/8/13 21:46
 */
public class LCR087 {

    public List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        backTracking(s,0,0);
        return res;
    }

    public void backTracking(String s, int startIdx, int pointNums) {
        //在点数上进行剪枝操作
        if (pointNums > 3) {
            return;
        }
        if (pointNums == 3) {
            if (isValid(s,startIdx,s.length()-1)) {
                res.add(s);
                return;
            }
        }
        for (int i = startIdx; i < s.length(); i++) {
            if (isValid(s,startIdx,i)) {
                StringBuilder stringBuilder = new StringBuilder(s);
                stringBuilder.insert(i+1,'.');
                backTracking(stringBuilder.toString(),i + 2, pointNums + 1);
                s = stringBuilder.deleteCharAt(i+1).toString();
            } else {
                //剪枝：当前位置不适合插入'.',提前返回
                return;
            }
        }

    }

    /**
     * 判断数字是否符合题意
     * @param s
     * @param start
     * @param end
     * @return
     */
    public boolean isValid(String s, int start, int end) {
        if (start >= s.length()) {
            return false;
        }

        int firstIdx = -1;
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            //判断数字中是否存在非数字字符
            if (!Character.isDigit(c)) {
                return false;
            }
            if (firstIdx == -1 && c == '0') {
                firstIdx = i;
            }
        }
        //判断数字中是否存在前缀0
        if (firstIdx == start && end > start) {
            return false;
        }
        int x = Integer.parseInt(s.substring(start, end + 1));
        if (x < 0 || x > 255) {
            return false;
        }
        return true;
    }
}
