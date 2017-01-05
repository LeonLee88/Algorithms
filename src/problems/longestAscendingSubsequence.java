package problems;

public class longestAscendingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {1,1,1,3,5,2};
		longest(a);
	}

	public static int longest(int[] array) {
	    if(array.length == 0) {
	      return 0;
	    }
	    int[] M = new int[array.length];// M[i] represent from the 0th element to i-th element, the length of the longest ascending subsequence
	    M[0] = 1;
	    for(int i=1; i<array.length; i++){
	      M[i] = 1;
	      for(int j=0;j<i;j++){
	        if(array[j] < array[i]){
	          M[i] = Math.max(M[i], M[j]+1);
	        }
	      }
	    }
	    return M[array.length-1];
	  }
}
