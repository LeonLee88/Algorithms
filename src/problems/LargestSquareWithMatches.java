package problems;

public class LargestSquareWithMatches {

    public int largestSquare(Node[][] matrix) {
        if (matrix == null) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int maxSquareLen = 0;

        // fill in the node
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Node cur = matrix[i][j];
                if (cur.hasLeft) {
                    cur.fromLeft = matrix[i][j - 1].fromLeft + 1;
                }
                if (cur.hasUp) {
                    cur.fromUp = matrix[i - 1][j].fromUp + 1;
                }
                maxSquareLen = Math.max(maxSquareLen(matrix, i, j, cur), maxSquareLen);
            }
        }

        return maxSquareLen;
    }

    int maxSquareLen(Node[][] matrix, int i, int j, Node cur) {

        int len = Math.min(cur.fromLeft, cur.fromUp);
        for (int k = len; k > 0; k--) {
            if (matrix[i][j - k].fromUp >= k && matrix[i - k][j].fromLeft >= k) {
                return k;
            }
        }
        return 0;
    }

    static class Node {
        boolean hasLeft;
        boolean hasUp;
        int fromLeft = 0;
        int fromUp = 0;
    }
}
