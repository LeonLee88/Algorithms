package problems;
import java.util.*;
public class ShortestPathInMaze {

	/* Find the shortest path from left up corner to right down corner in a 2D maze,
	 * there are some blocks in the maze, and the block is the cell with value 1.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = new int[][]{{0, 1, 0, 0, 0},
				                {0, 1, 0, 1, 0},
				                {0, 0, 0, 1, 0},
				                {1, 0, 1, 1, 0},
				                {0, 0, 0, 1, 0},
				                {0, 1, 0, 0, 0},
				                {0, 1, 1, 1, 0},
				                {0, 1, 0, 0, 0},
				                {0, 0, 0, 0, 0}};
		findShortest(a);
	}
	
	private static int findShortest(int[][] maze){
		if(maze == null || maze.length == 0) return Integer.MAX_VALUE;
		
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		Queue<Pair> queue = new LinkedList<>();
		Pair start = new Pair(0, 0);
		start.path = 1;
		queue.offer(start);
		visited[0][0] = true;
		//BFS-1
		while(!queue.isEmpty()){
			Pair cur = queue.poll();
			if(cur.x == maze.length-1 && cur.y == maze[0].length-1) {
				return cur.path;
			}
			List<Pair> neis = getNeis(maze, cur.x, cur.y);
			for(Pair nei : neis){
				if(!visited[nei.x][nei.y]) {
					visited[nei.x][nei.y] = true;
					nei.path = cur.path+1;
					queue.offer(nei);
				}
			}
		}
		return Integer.MAX_VALUE;
	}
	
	private static List<Pair> getNeis(int[][] maze, int x, int y){
		List<Pair> result = new ArrayList<>();
		
		if(x-1 >= 0 && maze[x-1][y] == 0){
			result.add(new Pair(x-1, y));
		}
		if(x+1 < maze.length && maze[x+1][y] == 0){
			result.add(new Pair(x+1, y));
		}
		if(y-1 >= 0 && maze[x][y-1] == 0){
			result.add(new Pair(x, y-1));
		}
		if(y+1 < maze[0].length && maze[x][y+1] == 0){
			result.add(new Pair(x, y+1));
		}
		return result;
	}
	
	static class Pair {
		int x;
		int y;
		int path;
		public Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
