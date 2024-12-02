package leetcode.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @author: lzy
 * @time: 2024/12/2 14:24
 */
public class M0104 {
    /**
     * 方法1：使用hashMap统计每一个字符的出现频率
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c,1);
            } else {
                map.put(c,map.get(c) + 1);
            }
        }
        int single = 0;
        for (Integer v : map.values()) {
            if (v % 2 == 1) {
                single += 1;
            }
        }
        return single <= 1;
    }

    /**
     * 方法2：使用int数组统计每一个字符的出现频率
     * @param s
     * @return
     */
    public boolean canPermutePalindrome2(String s) {
        //直接根据字符的ascii码作为index将出现频率存入int数组中
        int[] cnt = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt[c] += 1;
        }
        int single = 0;
        for (int v : cnt) {
            if (v % 2 == 1) {
                single += 1;
            }
        }
        return single <= 1;
    }
}
