package niuke;

/**
 * @description: 矩阵最长递增路径 记忆化搜索
 * @author: lzy
 * @time: 2024/8/12 16:27
 */
public class BM61 {
    public int solve(int[][] matrix) {
        // write code here
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int ans = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] res = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans,dfs(matrix,i,j,res,visited));
            }
        }
        return ans;
    }

    public int dfs(int[][] mat, int x, int y, int[][] res, boolean[][] visited) {
        //如果当前位置已经记录了结果，直接返回
        if (res[x][y] != 0) {
            return res[x][y];
        }
        //否则，求出这个位置的最长递增路径长度
        visited[x][y] = true;
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        int len = 0;
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < dx.length; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && mat[nx][ny] > mat[x][y]) {
                len = Math.max(len,dfs(mat,nx,ny,res,visited));
            }
        }
        res[x][y] = len + 1;
        visited[x][y] = false;
        return res[x][y];
    }
}
