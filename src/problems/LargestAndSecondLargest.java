package problems;
import java.util.LinkedList;

public class LargestAndSecondLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[] {5,4,3,2,1};
		largestAndSecond(a);
	}

	// n comparasion to find the largest and create a list of length log(n)
	// find the largest number in the list
	public static int[] largestAndSecond(int[] array) {
		Element[] helper = convert(array);
		int length = array.length;
		while (length > 1) {
			compareAndSwap(helper, length);
			length = (length+1) / 2;
		}

		return new int[] { helper[0].value,
				secondLargest(helper[0].comparedValues) };
	}

	private static Element[] convert(int[] array) {
		Element[] helper = new Element[array.length];
		for (int i = 0; i < array.length; i++) {
			helper[i] = new Element(array[i]);
		}
		return helper;
	}

	private static void compareAndSwap(Element[] helper, int leftPartitionlength) {
		for (int i = 0; i < leftPartitionlength / 2; i++) {
			if (helper[i].value < helper[leftPartitionlength - 1 - i].value) {
				swap(helper, i, leftPartitionlength - 1 - i);
			}
			helper[i].comparedValues
					.add(helper[leftPartitionlength - 1 - i].value);
		}
	}

	private static void swap(Element[] helper, int i, int j) {
		Element temp = helper[i];
		helper[i] = helper[j];
		helper[j] = temp;
	}

	private static int secondLargest(LinkedList<Integer> list) {
		int result = Integer.MIN_VALUE;
		for (int num : list) {
			result = Math.max(result, num);
		}
		return result;
	}

}

class Element {
	int value;
	LinkedList<Integer> comparedValues;

	Element(int value) {
		this.value = value;
		this.comparedValues = new LinkedList<>();
	}
}