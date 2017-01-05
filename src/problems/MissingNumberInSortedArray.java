package problems;

public class MissingNumberInSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MissingNumberInSortedArray a = new MissingNumberInSortedArray();
		int[] input = {1, 2,3,4,5, 7};
		a.missing(input);
	}

	public int missing(int[] array) {
		// special case
		if (array.length == 1) {
			return array[0] == 1 ? 2 : 1;
		}
		// approach: find the first number which greater then its index by 2
		int left = 0;
		int right = array.length-1;
		int n = array.length + 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (mid - 1 > 0 && array[mid] - array[mid - 1] == 2) {
				return array[mid] - 1;
			} else if (array[mid] - mid == 1) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		if (left == 0) {
			return 1;
		} else {
			return array.length + 1;
		}
	}

}
