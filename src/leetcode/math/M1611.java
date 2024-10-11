package leetcode.math;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: lzy
 * @time: 2024/9/29 19:42
 */
public class M1611 {
    public int[] divingBoard(int shorter, int longer, int k) {
        int[] res = new int[k + 1];
        //从小到大组合所有情况
        if (longer == shorter) {
            if (k == 0) {
                return new int[0];
            } else {
                return new int[] {shorter * k};
            }
        }
        for (int i = 0; i <= k; i++) {
            res[i] = shorter * (k - i) + longer * i;
        }
        return res;
    }
}
