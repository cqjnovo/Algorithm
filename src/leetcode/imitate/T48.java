package leetcode.imitate;

/**
 * @description: 旋转图像
 * @author: lzy
 * @time: 2024/8/21 13:25
 */
public class T48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //先水平翻转  再对角线翻转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i != j) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }
}
