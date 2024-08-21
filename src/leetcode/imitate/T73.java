package leetcode.imitate;

import javax.swing.text.html.HTMLDocument;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @description:
 * @author: lzy
 * @time: 2024/8/21 16:00
 */
public class T73 {

    /**
     * 基于两个辅助数组rows cols,空间复杂度为O(m+n)
     * @param matrix
     */
    public void setZeroes1(int[][] matrix) {
        //统计哪一行 哪一列需要置为0
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 使用常量的空间
     * @param matrix
     */
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //flag1,flag2分别用于统计第0行，第0列是否含有0
        boolean flag1 = false;
        boolean flag2 = false;
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flag1 = true;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flag2 = true;
            }
        }

        //将第0行 和 第0列当作方法一中的rows 和 cols 辅助数组
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //根据辅助数组中的值,给需要修改的地方赋值为0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        //根据flag1，flag2的值，分别给第0行第0列赋0
        if (flag1) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (flag2) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
