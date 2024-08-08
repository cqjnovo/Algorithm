package niuke;

import java.util.Arrays;

/**
 * @description:
 * @author: lzy
 * @time: 2024/8/8 13:09
 */
public class BM99 {
    public int[][] rotateMatrix (int[][] mat, int n) {
        // write code here
        int[][] res = new int[mat.length][];
        for (int i = 0; i < mat.length; i++) {
            res[i] = Arrays.copyOf(mat[i],mat[i].length);
        }
        //将第i行的值依次赋给第n-i-1列
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n-1-i]=mat[i][j];
            }
        }
        return res;
    }
}
