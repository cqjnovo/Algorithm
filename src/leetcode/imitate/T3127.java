package leetcode.imitate;

/**
 * @description: 构造相同颜色的正方形
 * @author: lzy
 * 遍历grid中所有2*2的区域，如果区域内有黑色或者白色>=3个，就满足题意
 * @time: 2024/8/31 22:20
 */
public class T3127 {
    public boolean canMakeSquare(char[][] grid) {
        int[][] loc = {{0,0},{0,1},{1,0},{1,1}};
        for (int i = 0; i < loc.length; i++) {
            int cnt_b = 0, cnt_w = 0;
            int x = loc[i][0], y = loc[i][1];
            for (int j = 0; j < loc.length; j++) {
                int dx = loc[j][0];
                int dy = loc[j][1];
                if (grid[x+dx][y+dy] == 'B') {
                    cnt_b += 1;
                } else {
                    cnt_w += 1;
                }
            }
            if (cnt_b >= 3 || cnt_w >= 3) {
                return true;
            }
        }
        return false;
    }
}
