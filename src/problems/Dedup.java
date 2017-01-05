package problems;
import java.util.Arrays;

public class Dedup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,1};
		dedup(a);
	}
	
	public static int[] dedup(int[] array) {
	    if(array.length <= 1) {
	      return array;
	    }
	    
	    int end = -1;
	    for(int i=0; i < array.length; i++) {
	      if(end == -1 || array[i] != array[end]) {
	        array[++end] = array[i];
	      } else {
	        while(array[i+1] == array[end] && i+1 < array.length){
	          i++;
	        }
	        end--;
	      }
	    }
	    return Arrays.copyOf(array, end+1);
	  }

}
