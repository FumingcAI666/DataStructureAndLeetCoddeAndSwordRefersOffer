package leetcode;

/**
 * @author macfmc
 * @date 2020/3/25-23:53
 */
public class m3_25_892 {
    /**
     892. 三维形体的表面积
     在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
     每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
     请你返回最终形体的表面积。

     示例 1：
     输入：[[2]]
     输出：10
     示例 2：
     输入：[[1,2],[3,4]]
     输出：34
     示例 3：
     输入：[[1,0],[0,2]]
     输出：16
     示例 4：
     输入：[[1,1,1],[1,0,1],[1,1,1]]
     输出：32
     示例 5：
     输入：[[2,2,2],[2,1,2],[2,2,2]]
     输出：46
     */
    public int surfaceArea(int[][] grid) {
        int[] dr = new int[]{0, 1, 0, -1};
        int[] dc = new int[]{1, 0, -1, 0};

        int N = grid.length;
        int ans = 0;

        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c)
                if (grid[r][c] > 0) {
                    ans += 2;
                    for (int k = 0; k < 4; ++k) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];
                        int nv = 0;
                        if (0 <= nr && nr < N && 0 <= nc && nc < N)
                            nv = grid[nr][nc];

                        ans += Math.max(grid[r][c] - nv, 0);
                    }
                }

        return ans;
    }
}
