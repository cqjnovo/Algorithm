package leetcode.sort;

import java.util.*;

/**
 * @description:
 * @author: lzy
 * @time: 2024/12/1 17:05
 */
public class M1002 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for (String a : strs) {
            char[] charArray = a.toCharArray();
            Arrays.sort(charArray);
            String s = new String(charArray);
            if (!map.containsKey(s)) {
                List<String> temp = new ArrayList<>();
                temp.add(a);
                map.put(s,temp);
            } else {
                map.get(s).add(a);
            }
        }
        Iterator<List<String>> iterator = map.values().iterator();
        while (iterator.hasNext()) {
            res.add(iterator.next());
        }
        return res;
    }
}
