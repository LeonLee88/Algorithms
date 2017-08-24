package problems;

import java.util.Arrays;

public class NumberOfDistinctSubstrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberOfDistinctSubstrings sol = new NumberOfDistinctSubstrings();
		sol.NumberOfDistinctSubstrings("BANANA");
	}
	
	public int NumberOfDistinctSubstrings(String s){
		String[] suffixes = new String[s.length()];
		for(int i=0; i < s.length(); i++){
			suffixes[i] = s.substring(i);
		}
		Arrays.sort(suffixes);
		int num = suffixes[0].length();
		for(int i=0; i<suffixes.length-1;i++){
			num += suffixes[i + 1].length() - longestCommonPrefix(suffixes[i], suffixes[i + 1]);
			System.out.println(suffixes[i] +" "+ suffixes[i + 1] + ":" + longestCommonPrefix(suffixes[i], suffixes[i + 1]));
		}
		return num;
	}
	
	private int longestCommonPrefix(String s1, String s2){
		int res = 0;
		int len1 = s1.length();
		int len2 = s2.length();
		int i = 0;
		int j = 0;
		while(i < len1 && j < len2) {
			if(s1.charAt(i) == s2.charAt(j)) {
				res++;
				i++;
				j++;
			} else {
				break;
			}
		}
		return res;
	}

}
