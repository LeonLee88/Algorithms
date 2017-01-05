package problems;

public class SpiralGenerateOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		spiralGenerate(3,4);
	}
	
	public static int[][] spiralGenerate(int m, int n) {
	    // Write your solution here.
	    int[][] result = new int[m][n];
	    if(m == 0 || n == 0){
	      return result;
	    }
	    int num = 1;
	    int left = 0, right = n-1;
	    int up = 0, down = m-1;
	    
	    while(left<right && up < down) {
	      for(int i= left;i<=right;i++) {
	        result[up][i] = num++;
	      }
	      
	      for(int i= up+1;i<= down-1;i++) {
	        result[i][right] = num++;
	      }
	      
	      for(int i= right;i>=left;i--) {
	        result[down][i] = num++;
	      }
	      
	      for(int i= down-1;i>=up+1;i--) {
	        result[i][left] = num++;
	      }
	      left++;
	      right--;
	      up++;
	      down--;
	    }
	    
	    // nothing left
	    if(left > right || up > down){
	      return result;
	    }
	    
	    // one column left
	    if(left == right){
	      for(int i=up; i < down; i++) {
	        result[i][left] = num++;
	      }
	    } else {
	      for(int i=left; i <= right; i++) {
	        result[up][i] = num++;
	      }
	    }
	    return result;
	  }

}
