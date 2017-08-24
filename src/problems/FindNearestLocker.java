package problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindNearestLocker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//if m[i][j] = 1, then it's locker.Otherwise,  m[i][j] = 0, it's city unit
	
	public void findNearestLocker(int[][] city){
		
	}
	
	public void updateNearestLocker(int[][] city, int i, int j){
		int m = city.length;
		int n = city[0].length;
		boolean[][] visited = new boolean[m][n];
		int pathCost = 1;
		Queue<Pair> queue = new LinkedList<>();
		
		queue.offer(new Pair(i,j));
		
		while(!queue.isEmpty()){
			int size = queue.size();
			for(int s=0; s < size; s++) {
				Pair cur = queue.poll();
				 List<Pair> neis = getNeis(cur.i, cur.j, city, visited);
				 for(Pair nei : neis){
					 city[nei.i][nei.j] = Math.min(pathCost, city[nei.i][nei.j]);
					 visited[nei.i][nei.j] = true;
				 }
			}
			pathCost++;
		}
		
	}
	
	public List<Pair> getNeis(int i, int j, int[][] city, boolean[][] visited){
		List<Pair> neis = new LinkedList<>();
		if(i-1 >= 0 && !visited[i-1][j] && city[i-1][j] != 1){
			neis.add(new Pair(i-1, j));
		}
		if(i+1 < city.length && !visited[i+1][j] && city[i+1][j] != 1){
			neis.add(new Pair(i+1, j));
		}
		if(j-1 >= 0 && !visited[i][j-1] && city[i][j-1] != 1){
			neis.add(new Pair(i, j-1));
		}
		if(j+1 < city[0].length && !visited[i][j+1] && city[i][j+1] != 1){
			neis.add(new Pair(i, j+1));
		}
		return neis;
	}
	
	
	static class Pair {
		int i;
		int j;
		public Pair(int i, int j){
			this.i = i;
			this.j = j;
		}
	}

}
