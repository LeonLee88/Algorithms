package problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Hopper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 2, 1, 1, 1, 1, 0 };
		int[] a = { 2, 4, 3, 1, 3, 1, 1, 1, 2 };
		int[] test_canjump4_0 = { 4, 2, 1, 2, 0, 0 };
		int[] test_canjump4 = { 1, 3, 1, 2, 2 };
		Hopper sol = new Hopper();
		sol.minJump3(a);
		sol.minJump4(test_canjump4_0, 0);
	}

	public int minJump(int[] array) {
		int[] canjump = new int[array.length];
		canjump[0] = 0;
		for (int i = 1; i < array.length; i++) {
			// initialize -1 to indicate it's not reachable
			canjump[i] = -1;
			for (int j = 0; j < i; j++) {
				if (canjump[j] >= 0 && array[j] >= i - j
						&& (canjump[i] == -1 || (canjump[j] + 1) < canjump[i])) {
					canjump[i] = canjump[j] + 1;
				}
			}
		}
		return canjump[array.length - 1];
	}

	public int minJump3(int[] array) {
		int[] canjump = new int[array.length];
		canjump[0] = 0;
		int jumpout = -1;
		for (int i = 1; i < array.length; i++) {
			canjump[i] = -1;
			for (int j = 0; j < i; j++) {
				if (canjump[j] != -1 && array[j] + j >= i) {
					if (canjump[i] == -1 || canjump[j] + 1 < canjump[i]) {
						canjump[i] = canjump[j] + 1;
					}
				}
			}
			// update jumpout if 1. we can reach i and 2. we can jump out from i
			// 3. canjump[i]+1 is less than current jumpout
			if (canjump[i] != -1 && array[i] + i >= array.length) {
				if (jumpout == -1 || jumpout > canjump[i] + 1) {
					jumpout = canjump[i] + 1;
				}
			}
		}
		return jumpout;
	}

	public int minJump4(int[] array, int index) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[array.length];

		visited[index] = true;
		int cost = 0;
		queue.offer(index);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Integer cur = queue.poll();
				if (cur == array.length - 1) {
					return cost;
				}
				generate(array, cur, queue, visited);
			}
			cost++;
		}
		return -1;
	}

	public void generate(int[] array, int index, Queue<Integer> queue, boolean[] visited) {
		for (int i = 0; i < array.length; i++) {
			if (!visited[i] && i != index && Math.abs(i - index) <= array[index]) {
				queue.offer(i);
				visited[i] = true;
			}
		}
	}

}
