package leetcode.graph;

/**
 * @description: 被围绕的区域
 * @author: lzy
 * @time: 2024/8/26 9:20
 * 从四周出发，对遇到的所有的"O"进行DFS,标记这些位置是不能被围绕的
 * 对于未被标记的"O"则是可以被围绕的,可以把它们修改为"X"
 */
public class T130 {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        //第1列 和 最后一列寻找'O'
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board, visited);
            }
            if (board[i][n - 1] == 'O') {
                dfs(i, n - 1, board, visited);
            }
        }
        //第1行 和 最后一行寻找"O"
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(0, j, board, visited);
            }
            if (board[m - 1][j] == 'O') {
                dfs(m - 1, j, board, visited);
            }
        }
        //如果已经被置为true的'O'是不可被围绕的,其余的'O'可以被修改为'X'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public void dfs(int x, int y, char[][] board, boolean[][] visited) {
        visited[x][y] = true;
        int[][] neighbours = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < neighbours.length; i++) {
            int dx = neighbours[i][0];
            int dy = neighbours[i][1];
            if (isValid(dx + x, dy + y, board.length, board[0].length)) {
                if (!visited[x + dx][y + dy] && board[x + dx][y + dy] == 'O') {
                    dfs(x + dx, y + dy, board, visited);
                }
            }
        }
    }
}
