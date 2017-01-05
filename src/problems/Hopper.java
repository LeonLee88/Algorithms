package problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Hopper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 2, 1, 1, 1, 1, 0 };
		int[] a = { 2, 4, 3, 1, 3, 1, 1, 1, 2 };
		int[] test_canjump4 = { 3, 3, 1, 0, 0 };
		Hopper sol = new Hopper();
		sol.minJump3(a);
		sol.minJump4(test_canjump4, 2);
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
		int[][] graph = buildGraph(array);
		PriorityQueue<Node> minHeap = new PriorityQueue<>(10,
				new Comparator<Node>() {
					@Override
					public int compare(Node n1, Node n2) {
						if (n1.cost == n2.cost) {
							return 0;
						}
						return n1.cost < n2.cost ? -1 : 1;
					}
				});
		Map<Integer, Node> visited = new HashMap<>();
		Node seed = new Node(index);
		seed.cost = 0;
		minHeap.offer(seed);
		visited.put(index, seed);

		while (!minHeap.isEmpty()) {
			Node cur = minHeap.poll();
			if (cur.key == array.length - 1) {
				return cur.cost;
			}
			List<Integer> neis = getNeis(cur, graph);
			for (Integer nei : neis) {
				Node neiNode = null;
				if (!visited.containsKey(nei)) {
					neiNode = new Node(nei);
					neiNode.cost = cur.cost + 1;
				} else {
					neiNode = visited.get(nei);
					minHeap.remove(neiNode); // cost has been changed, we need to remove it and push it back
					neiNode.cost = Math.min(neiNode.cost, cur.cost + 1);
				}
				minHeap.offer(neiNode);
				visited.put(nei, neiNode);
			}
		}
		return -1;
	}

	public int[][] buildGraph(int[] array) {
		int[][] graph = new int[array.length][array.length];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (i != j && Math.abs(i - j) <= array[i]) {
					graph[i][j] = 1;
				}
			}
		}
		return graph;
	}

	// change to integer, element is the key of neis
	public List<Integer> getNeis(Node n, int[][] graph) {
		List<Integer> neis = new ArrayList<>();
		for (int i = 0; i < graph.length; i++) {
			if (graph[n.key][i] != 0) {
				neis.add(i);
			}
		}
		return neis;
	}

	static class Node {
		int key; // key of node
		int cost;

		public Node(int key) {
			this.key = key;
			this.cost = Integer.MAX_VALUE;
		}
	}

}
