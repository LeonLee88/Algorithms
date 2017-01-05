package problems;
public class reverseWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(reverseWords("I love Yahoo"));
	}

	public static String reverseWords(String input) {
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] array = input.toCharArray();
		// reverse the whole string
		reverse(array, 0, array.length-1);
		int slow = 0;
		int fast = 0;
		while (fast < array.length) {
			if(fast == array.length - 1) {
				reverse(array, slow, fast);
				slow = ++fast;
			} else if (array[fast] == ' ') {
				reverse(array, slow, fast - 1);
				slow = ++fast;
			}
			fast++;
		}
		return new String(array);
	}

	private static void reverse(char[] array, int start, int end) {
		char temp;
		while (start < end) {
			temp = array[start];
			array[start++] = array[end];
			array[end--] = temp;
		}
	}
}
