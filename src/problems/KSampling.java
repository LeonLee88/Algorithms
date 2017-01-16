package problems;

import java.util.ArrayList;
import java.util.List;

public class KSampling {

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			KSampling sol = new KSampling(2);
			sol.read(0);
			sol.read(1);
			sol.read(2);
			sol.read(3);
			sol.read(4);
			System.out.println(sol.sample());
		}
	}

	private final int k;
	private int counter;
	private List<Integer> result;

	public KSampling(int k) {
		// Complete the constructor if necessary.
		this.k = k;
		counter = 0;
		result = new ArrayList<Integer>();
	}

	public void read(int value) {
		// Write your implementation here.
		if (counter < k) {
			result.add(value);
			counter++;
			return;
		}
		int r = (int) (Math.random() * ++counter);
		if (r < k) {
			result.set(r, value);
		}
	}

	public List<Integer> sample() {
		// Write your implementation here.
		return this.result;
	}
}
