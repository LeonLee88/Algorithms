package problems;

public class numOfTrees {

	/*
	 * Find Number of BSTs Generated Find the number of different Binary Search
	 * Trees generated from 1-n.
	 * 
	 * Example:
	 * 
	 * Input: 3, Return: 5
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		numOfTrees sol = new numOfTrees();
		sol.numOfTrees(5);
	}

	public int numOfTrees(int n) {
		if (n == 0) {
			return 0;
		}
		int[] M = new int[n + 1];
		M[0] = 1;
		M[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i / 2; j++) {
				M[i] += M[j] * M[i - j - 1]; // M(0)*M(n-1) + M(1)*M(n-2) + .... + M((n-1)/2)*M((n-1)/2)
			}
			M[i] = M[i] * 2 + i % 2 * (M[(i - 1) / 2] * M[(i - 1) / 2]);
		}
		return M[n];
	}

}
