package problems;

/**
 * Created by leon on 9/2/17.
 */
public class OutOfBoundaryPaths {
    final static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int MOD = 1000000000 + 7;
    public int findPaths(int m, int n, int N, int i, int j) {
        int[][] grid = new int[m][n];
        int[][][] mem = new int[m][n][N+1];
        // Init the mem with -1
        for(int x=0; x < m; x++) {
            for(int y=0; y < n; y++) {
                for(int z=0; z < N+1; z++) {
                    mem[x][y][z] = -1;
                }
            }
        }
        int paths = helper(i, j, N, grid, mem);
        return paths;
    }

    public int helper(int i, int j, int stepsLeft, int[][] grid, int[][][] mem) {
        if (stepsLeft < 0) {
            return 0;
        }
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0) {
            return 1;
        }
        if(mem[i][j][stepsLeft] >= 0) {
            return mem[i][j][stepsLeft];
        }
        int paths = 0;
        for (int k = 0; k < dirs.length; k++) {
            paths += helper(i + dirs[k][0], j + dirs[k][1], stepsLeft - 1, grid, mem);
        }
        mem[i][j][stepsLeft] = paths % MOD;
        return paths;
    }

    public int dpHelper(int m, int n, int N, int i, int j) {
        int[][] dp = new int[m][n];
        dp[i][j] = 1;
        int count = 0;
        for(int x=0; x < N; x++) {
            int[][] temp = new int[m][n];
            for(int y=i; y < m; y++) {
                for(int z=j; z < n; z++) {
                    for(int k = 0; k < dirs.length; k++) {
                        int ny = y + dirs[k][0];
                        int nz = z + dirs[k][1];
                        if(ny < 0 || ny >= m || nz < 0 || nz >= n) {
                            count = (count + dp[y][z]) % MOD;
                        } else {
                            temp[ny][nz] = (temp[ny][nz] + dp[y][z]) % MOD;
                        }
                    }
                }
            }
            dp = temp;
        }
        return count;
    }
}
