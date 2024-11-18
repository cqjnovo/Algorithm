package leetcode.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @description: 最长回文串
 * 如果某个字符数量是偶数，偶数个字符都可以被用于构造回文串
 * 如果某个字符数量是奇数，它的个数-1个该字符可以被用于构造回文串
 * 但如果这个字符串中包含奇数个的字符，答案可以+1，因为可以有一个奇数个元素放在中间
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
