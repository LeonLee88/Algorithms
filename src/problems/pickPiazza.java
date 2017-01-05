package problems;

public class pickPiazza {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[] { 1, 3, 4, 5, 7, 9, 2, 10 };
		largestPiazza(array);
	}

	public static int largestPiazza(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int n = array.length;
        int[][] M = new int[n][n]; // M[i][j] represents maximum sum of piazza I can pick from i to j

        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (i - j == 0) { // 1 piece of piazza
                    M[j][i] = array[i];
                } else if (i - j == 1) { // 2 pieces of piazzas
                    M[j][i] = Math.max(array[i], array[j]);
                } else {
                    // if pick left side
                    int pickLeft = array[j] + (array[j + 1] > array[i] ? M[j + 2][i] : M[j + 1][i - 1]);
                    // if pick right side
                    int pickRight = array[i] + (array[j] > array[i - 1] ? M[j + 1][i - 1] : M[j][i - 2]);
                    // update M[j][i] if feasible
                    M[j][i] = Math.max(M[j][i], Math.max(pickLeft, pickRight));
                }
            }
        }

        return M[0][n-1];
    }

}
