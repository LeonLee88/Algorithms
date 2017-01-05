package problems;
public class rotateMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] m = new int[][] { { 1, 2, 3 },

		{ 8, 9, 4 },

		{ 7, 6, 5 } };

		rotate(m);
		int[][] a = m;
	}

	public static void rotate(int[][] matrix) {
		if (matrix.length == 0) {
			return;
		}
		int n = matrix.length;
		int left = 0;
		int right = n - 1;
		int up = 0;
		int down = n - 1;
		for (int k = n; k > 0; k /= 2) {
			for (int i = 0; i < k-1; i++) {
				int temp = matrix[up][left+i];
				matrix[up][left+i] = matrix[down - i][left];
				matrix[down - i][left] = matrix[down][right - i];
				matrix[down][right - i] = matrix[up + i][right];
				matrix[up + i][right] = temp;
			}
			left++;
			right--;
			up++;
			down--;
		}
	}

}
