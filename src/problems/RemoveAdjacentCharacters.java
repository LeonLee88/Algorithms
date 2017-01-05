package problems;

public class RemoveAdjacentCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(deDup("abbbccd"));
	}
	
	public static String deDup(String input) {
	    if(input == null && input.length() <= 1){
	      return input;
	    }
	    
	    char[] array = input.toCharArray();
	    int slow = -1;
	    int fast = 0;
	    while(fast < array.length){
	      if(slow == -1) {
	        array[++slow] = array[fast++];
	      } else if(array[slow] != array[fast]){
	        array[++slow] = array[fast++];
	      } else {
	        while(fast < array.length && array[slow] == array[fast]){
	          fast++;
	        }
	        slow--;
	      }
	    }
	    return new String(array, 0, slow+1);
	  }

}
