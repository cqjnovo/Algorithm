package leetcode.dfs;

/**
 * 记忆化搜索
 * @description:矩阵中的最长递增路径
 * @author: lzy
 * @time: 2024/8/13 21:23
 */
public class T329 {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 0 || n == 0) {
            return 0;
        }
        int ans = 0;
        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans,dfs(matrix,i,j,res,visited));
            }
        }
        return ans;
    }

    public int dfs(int[][] mat, int x, int y, int[][] res, boolean[][] visited) {
        if (res[x][y] != 0) {
            return res[x][y];
        }
        visited[x][y] = true;
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        int maxVal = 0;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < mat.length && ny >= 0 && ny < mat[0].length && !visited[nx][ny] && mat[nx][ny] > mat[x][y]) {
                maxVal = Math.max(maxVal,dfs(mat,nx,ny,res,visited));
            }
        }
        visited[x][y] = false;
        res[x][y] = maxVal + 1;
        return res[x][y];
    }
}
