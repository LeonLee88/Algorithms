package problems;

public class ReOrderArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,2,3,4};
		reorder(input);
	}
	
	public static int[] reorder(int[] array) {
	    reorder(array, 0, array.length-1);
	    return array;
	  }
	  
	  public static void reorder(int[] array, int start, int end) {
	    if(end - start <= 2){
	      return;
	    }
	    int mid = start + (end - start)/2 + ((end - start) % 2 == 0 ? 0 : 1);
	    reverse(array, start+1, mid-1);
	    reverse(array, start+1, mid);
	    reorder(array, start+2, end);
	  }
	  
	  public static void reverse(int[] array, int start, int end){
	    while(start < end){
	      swap(array, start++, end--);
	    }
	  }
	  
	  public static void swap(int[] array, int i, int j) {
	    int temp = array[i];
	    array[i] = array[j];
	    array[j] = temp;
	  }

}
