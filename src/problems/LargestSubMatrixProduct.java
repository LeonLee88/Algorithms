package problems;

public class LargestSubMatrixProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[][] matrix = { { 1, -0.2, -1 }, { 1, -1.5, 1 }, { 0, 0, 1 } };
		double[][] matrix1 = {{2.0, -1.0, 0.5, 1.0, -3.0},
							  {0.0, -2.0, -1.0, 2.0, 0.1},
							  {3.0, 0.2, 1.0, -3.0, -2.0}};
		LargestSubMatrixProduct sol = new LargestSubMatrixProduct();
		sol.largest(matrix1);
	}
	
	public double largest(double[][] matrix) {
		if(matrix == null || matrix.length == 0) {
			return 0.0;
		}
		double result = Double.NEGATIVE_INFINITY;
		
		for(int i=0; i<matrix.length; i++){
			double[] cur = new double[matrix[0].length];
			for(int j=i; j>=0; j--){
				multiply(cur, matrix[j]);
				result = Math.max(result, largestSubArrayProduct(cur));
			}
		}
		return result;
	}
	
	public double largestSubArrayProduct(double[] array){
		double result = array[0];
		double curMax;
		double curMin;
		double preMax = array[0];
		double preMin = array[0];
		
		for(int i=1; i<array.length; i++) {
			curMax = Math.max(Math.max(preMax*array[i], preMin*array[i]), array[i]);
			curMin = Math.min(Math.min(preMax*array[i], preMin*array[i]), array[i]);
			result = Math.max(result, curMax);
			preMax = curMax;
			preMin = curMin;
		}
		return result;
	}
	
	private void multiply(double[] cur, double[] matrix){
		for(int i=0; i<cur.length; i++){
			cur[i] = (cur[i] == 0.0) ? matrix[i] : cur[i] * matrix[i];
		}
	}

}
