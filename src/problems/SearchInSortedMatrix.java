package problems;

public class SearchInSortedMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input = new int[][] {{1,2,3,4},{5,5,6,7},{7,7,9,10}};
		search(input, 8);
	}
	
	public static int[] search(int[][] matrix, int target) {

	    int row = matrix.length;
	    int col = matrix[0].length;
	    int left = 0, right = row*col-1;
	    
	    while(left<=right){
	      int mid = left + (right-left)/2;
	      if(matrix[mid/col][mid%col] == target) {
	        return new int [] {mid/col, mid%col};
	      } else if(matrix[mid/col][mid%col] < target){
	        left = mid+1;
	      } else {
	        right = mid-1;
	      }
	    }
	    
	    return new int[] {-1, -1};
	  }

}
