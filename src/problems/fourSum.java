package problems;
import java.util.*;
public class fourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean sum(int[] array, int target ){
		Map<Integer, Pair> map = new HashMap<>();
		for(int j=0; j<array.length; j++){
			for(int i=0; i<j;i++){
				int sum = array[i] + array[j];
				if(map.containsKey(target - sum) && map.get(target - sum).right < i) {
					return true;
				}
				
				if(!map.containsKey(sum)){
					map.put(sum, new Pair(i, j));
				}
			}
		}
		return false;
	}

}

class Pair{
	int left;
	int right;
	Pair(int left, int right){
		this.left = left;
		this.right = right;
	}
}
