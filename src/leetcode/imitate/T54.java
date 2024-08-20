package leetcode.imitate;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 螺旋矩阵
 * @author: lzy
 * @time: 2024/8/20 9:53
 */
public class T54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int i = 0, j = 0;
        int cnt = 0;
        int all = m * n;
        while (cnt < all) {
            //先向右
            while (j < n && !visited[i][j]) {
                res.add(matrix[i][j]);
                visited[i][j] = true;
                j += 1;
                cnt += 1;
            }
            j -= 1;
            i += 1;
            //向下遍历
            while (i < m && !visited[i][j]) {
                res.add(matrix[i][j]);
                visited[i][j] = true;
                i += 1;
                cnt += 1;
            }
            i -= 1;
            j -= 1;
            //向左遍历
            while (j >= 0 && !visited[i][j]) {
                res.add(matrix[i][j]);
                visited[i][j] = true;
                j -= 1;
                cnt += 1;
            }
            j += 1;
            i -= 1;
            //向上遍历
            while (i >= 0 && !visited[i][j]) {
                res.add(matrix[i][j]);
                visited[i][j] = true;
                i -= 1;
                cnt += 1;
            }
            i += 1;
            j += 1;
        }
        return res;
    }
}
