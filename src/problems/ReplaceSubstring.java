package problems;
import java.util.ArrayList;
public class ReplaceSubstring {

	public static void main(String[] args) {
		System.out.print(replace("aaa", "aa",""));

	}

	public static String replace(String input, String s, String t) {
		char[] array = input.toCharArray();
	    if(s.length() >= t.length()) {
	      return replaceShorter(array, s, t);
	    }
	    return replaceLonger(array, s, t);
	  }
	  
	  public static String replaceShorter(char[] input, String s, String t) {
	    int slow=0;
	    int fast=0;
	    while(fast < input.length){
	      if(equalSubstring(input, fast, s)){
	        copySubstring(input, slow, t);
	        slow+= t.length();
	        fast+= s.length();
	      } else {
	        input[slow++] = input[fast++];
	      }
	    }
	    return new String(input, 0, slow);
	  }
	  
	  public static String replaceLonger(char[] input, String s, String t) {
	    ArrayList<Integer> matches = finaAllMatches(input, s);
	    //allocate space for final result
	    char[] result = new char[matches.size()*(t.length() - s.length())+input.length];
	    int lastIndex = matches.size()-1;
	    // slow and fast move from right most side to the left most side
	    int slow=input.length-1;
	    int fast=result.length-1;
	    while(slow >= 0){
	      if(lastIndex >=0 && slow == matches.get(lastIndex)){
	        copySubstring(result, fast - t.length() + 1, t);
	        fast-=t.length();
	        slow-=s.length();
	        lastIndex--;
	      } else {
	        result[fast--] = input[slow--];
	      }
	    }
	    
	    return new String(result);
	  }
	  
	  //check if the substring starting from fromIndex equals to s
	  public static boolean equalSubstring(char[] input, int fromIndex, String s){
	    for(int i=0; i < s.length(); i++){
	      if(fromIndex + i >= input.length || input[fromIndex + i] != s.charAt(i)) {
	        return false;
	      }
	    }
	    return true;
	  }
	  
	  public static void copySubstring(char[] input, int fromIndex, String t){
	    for(int i=0; i < t.length(); i++){
	      input[fromIndex + i] = t.charAt(i);
	    }
	  }
	  
	  //find end position of all matches of s in input
	  public static ArrayList<Integer> finaAllMatches(char[] input, String s) {
	    ArrayList<Integer> matches = new ArrayList<Integer>();
	    int i=0;
	    while(i+s.length()-1 < input.length){
	      if(equalSubstring(input, i, s)){
	        matches.add(i+s.length()-1);
	        i+= s.length();
	      } else {
	        i++;
	      }
	    }
	    return matches;
	  }
}
