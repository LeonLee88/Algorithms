package problems;

public class MaxProduct {

	public static void main(String[] args) {
		System.out.print(maxProduct(10));

	}

	public static int maxProduct(int length) {
	    int[] M = new int[length+1];
	    if(length == 2){
	      return 1;
	    }
	    M[1] = 0;
	    M[2] = 1;
	    for(int i=3; i <= length; i++){
	      for(int j=1; j <= i ; j++) {
	        //for other partition, we can chose cutting or not cutting it, so the max
	        // number is either j or array[j]
	        M[i] = Math.max(j * Math.max(i-j, M[i-j]), M[i]);
	      }
	      //globalMax = Math.max(globalMax, M[i]);
	    }
	    return M[length];
	  }
}
