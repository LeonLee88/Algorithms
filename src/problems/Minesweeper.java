package problems;

/**
 * Created by leon on 8/26/17.
 */
public class Minesweeper {

    private final static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        dfs(board, click[0], click[1]);
        return board;
    }

    public void dfs(char[][] board, int i, int j) {

        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            return;
        }

        if (board[i][j] == 'E') {
            int numAdjacentMine = 0;
            for (int k = 0; k < 8; k++) {
                int x = i + dirs[k][0], y = j + dirs[k][1];
                if (0 <= x && x < board.length && 0 <= y && y < board[0].length && board[x][y] == 'M') {
                    numAdjacentMine++;
                }
            }

            if (numAdjacentMine > 0) {
                board[i][j] = (char) ('0' + numAdjacentMine);
            } else {
                board[i][j] = 'B';
                for (int k = 0; k < 8; k++) {
                    int x = i + dirs[k][0], y = j + dirs[k][1];
                    if (0 <= x && x < board.length && 0 <= y && y < board[0].length) {
                        dfs(board, x, y);
                    }
                }
            }
        }
    }
}
