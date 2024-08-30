package leetcode.binSearch;

/**
 * @description:
 * @author: lzy
 * @time: 2024/8/30 8:43
 */
public class T74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row_l = 0, row_r = m - 1;
        //首先找到target所在行
        while (row_l < row_r) {
            int row_mid = row_l + (row_r - row_l) / 2 + 1;
            if (target < matrix[row_mid][0]) {
                row_r = row_mid - 1;
            } else {
                row_l = row_mid;
            }
        }
        if (row_l < 0 || row_l >= m) {
            return false;
        }
        //row_l即为target可能位于的行
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[row_l][mid] > target) {
                r = mid - 1;
            } else if (matrix[row_l][mid] < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
