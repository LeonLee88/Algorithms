package problems;

public class Maze {

    private final static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, visited, start[0], start[1], destination);
    }

    public boolean dfs(int[][] maze, boolean[][] visited, int i, int j, int[] destination) {
        // roll to a wall towards given direction
        if (visited[i][j]) {
            return false;
        }

        if (i == destination[0] && j == destination[1]) {
            return true;
        }

        visited[i][j] = true;

        for (int k = 0; k < dirs.length; k++) {

            int x = i, y = j;

            while (0 <= x + dirs[k][0] && x + dirs[k][0] < maze.length &&
                    0 <= y + dirs[k][1] && y + dirs[k][1] < maze[0].length &&
                    maze[x + dirs[k][0]][y + dirs[k][1]] != 1) {
                x += dirs[k][0];
                y += dirs[k][1];
            }

            if (dfs(maze, visited, x, y, destination)) return true;
        }

        return false;
    }
}