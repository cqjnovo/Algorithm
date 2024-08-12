package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:括号生成
 * @author: lzy
 * @time: 2024/8/9 9:02
 */
public class T22 {
    public List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs(0,0,n,"");
        return res;
    }

    public void dfs(int left, int right, int n, String temp) {
        if (left == n && right == n) {
            res.add(temp);
            return;
        }
        if (left < n) {
            dfs(left+1,right,n,temp+'(');
        }
        if (right < n && right < left) {
            dfs(left,right+1,n,temp+")");
        }
    }
}
