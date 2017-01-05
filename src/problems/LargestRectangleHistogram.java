package problems;
import java.util.*;

public class LargestRectangleHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		largest(new int[]{5,4,3,2,1});
	}

	public static int largest(int[] array) {
		Deque<Integer> stack = new LinkedList<>();
		int result = 0;
		for (int i = 0; i <= array.length; i++) {
			// insert 0 to ensure we will finally pop the elements out of the
			// stack (when all elements in the input are ascending)
			int cur = i == array.length ? 0 : array[i];
			while (!stack.isEmpty() && array[stack.peekFirst()] >= cur) {
				int height = array[stack.pollFirst()];
				// left boundary of largest rectangle
				int left = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
				result = Math.max(result, (i - left) * height);
			}
			stack.offerFirst(i);
		}
		return result;
	}

}
