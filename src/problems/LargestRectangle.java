package problems;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 0, 0, 0, 0 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 },
				{ 1, 0, 1, 1 } };
		LargestRectangle sol = new LargestRectangle();
		sol.largest(matrix);
	}

	public int largest(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		// approach: build histograms using each row as bottom, do
		// "find largest restangle area" in all histograms
		// the maximum area is the result
		int[] h = new int[matrix[0].length];
		int result = 0;
		Deque<Integer> stack = new LinkedList<>();

		for (int i = 0; i < matrix.length; i++) {
			// compute the histograms
			for (int j = 0; j < matrix[0].length; j++) {
				h[j] = matrix[i][j] == 1 ? h[j] + 1 : 0;
			}

			// calclate the max area of the histograms
			for (int j = 0; j <= matrix[0].length; j++) {
				int curHeight = (j == matrix[0].length) ? 0 : h[j];
				while (!stack.isEmpty() && curHeight <= h[stack.peekFirst()]) {
					int top = stack.pollFirst();
					int height = h[top];
					int left = stack.isEmpty() ? 0 : stack.peek() + 1;
					result = Math.max(result, height * (j - left));
				}
				stack.offerFirst(j);
			}
			stack.pollFirst();// remove dummy (matrix[0].length) index we added the last step
		}
		return result;
	}

}
