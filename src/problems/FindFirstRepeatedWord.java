package problems;

import java.util.HashSet;
import java.util.Set;

public class FindFirstRepeatedWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "  dfd cee he,   yes he us. cee. whey: dthis dfd ";
		FindFirstRepeatedWord sol = new FindFirstRepeatedWord();
		sol.FindFirstRepeatedWord(s);
	}
	
	private String FindFirstRepeatedWord(String s){
		if(s == null || s.length() == 0) {
			return "";
		}
		String[] array = s.trim().split("[\\s\\.;,:\\-]+", 0);
		Set<String> set = new HashSet<>();
		for(int i = 0; i < array.length; i++) {
			if(set.contains(array[i])){
				return array[i];
			} else {
				set.add(array[i]);
			}
		}
		return "";
	}

}
