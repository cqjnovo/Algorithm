package niuke.backTracking;

import java.io.FilterOutputStream;
import java.util.ArrayList;

/**
 * @description: 数字字符串转化成IP地址
 * @author: lzy
 * @time: 2024/8/13 16:48
 */
public class BM74 {

    public ArrayList<String> res = new ArrayList<>();
    public static void main(String[] args) {
        String s = "0279245587303";
        BM74 obj = new BM74();
        obj.restoreIpAddresses(s);
        System.out.println(obj.res.size());
    }

    public ArrayList<String> restoreIpAddresses (String s) {
        // write code here
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        backTracking(s,0,0);
        return res;
    }

    public void backTracking(String s, int startIdx, int pointNum) {
        if (pointNum > 3) {
            return;
        }
        if (pointNum == 3) {
            if (isValid(s,startIdx,s.length() - 1)) {
                res.add(s);
                return;
            }
        }
        for (int i = startIdx; i < s.length(); i++) {
            if (isValid(s,startIdx,i)) {
                StringBuilder sb = new StringBuilder(s);
                s = sb.insert(i+1,".").toString();
                backTracking(s,i+2,pointNum+1);
                s = sb.deleteCharAt(i+1).toString();
            } else {
                return;
            }
        }

    }

    /**
     * 判断当前子串对应数字是否合法 左闭右闭
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
        //检查是否存在非数字字符
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
            if (firstIdx == -1 && c == '0') {
                firstIdx = i;
            }
        }
        //判断该子串对应数字是否在[0,255]区间内部
        int x = Integer.parseInt(s.substring(start, end + 1));
        if (x > 255 || x < 0) {
            return false;
        }
        //判断当前子串对应数字是否包含前缀0
        if (firstIdx == start && end > start) {
            return false;
        }
        return true;
    }
}
