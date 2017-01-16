package problems;

public class LargestSubarrayProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] a = {-1.0, 2.0, -3}; // -6
		LargestSubarrayProduct sol = new LargestSubarrayProduct();
		sol.largestProduct(a);
	}

	public double largestProduct(double[] array) {
		Double result = array[0];
		Double curMax; // max product including i
		Double curMin; // min product including i
		Double preMax = array[0]; // max product including i-1
		Double preMin = array[0]; // min product including i-1

		for (int i = 1; i < array.length; i++) {
			curMax = Math.max(Math.max(preMax * array[i], preMin * array[i]),
					array[i]);
			curMin = Math.min(Math.min(preMax * array[i], preMin * array[i]),
					array[i]);
			result = Math.max(curMax, result);
			preMax = curMax;
			preMin = curMin;
		}
		return result;
	}

}
