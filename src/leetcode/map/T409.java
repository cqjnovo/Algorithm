package leetcode.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: lzy
 * @time: 2024/8/8 21:55
 */
public class T409 {
    public int longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        //统计s中每个字符的个数
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (map.containsKey(c)) {
                map.put(c,map.get(c) + 1);
            } else {
                map.put(c,1);
            }
        }
        int res = 0;
        boolean flag = false;
        for (int val : map.values()) {
            if (val % 2 == 0) {
                res += val;
            } else {
                flag = true;
                res += (val - 1);
            }
        }
        if (flag == true) {
            res += 1;
        }
        return res;
    }
}
