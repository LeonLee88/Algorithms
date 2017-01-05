package problems;

public class generateMaze {
	public static void main(String[] args){
		maze(3);
	}
	public static int[][] maze(int n) {
	    int[][] maze = new int[n][n];
	    for(int i=0; i< n; i++){
	      for(int j=0; j<n; j++){
	        maze[i][j] = 1;
	      }
	    }
	    maze[0][0] = 0;
	    generate(maze, 0, 0);
	    return maze;
	  }
	  
	  private static void generate(int[][] maze, int x, int y) {
	    Dir[] dirs = Dir.values();
	    shuffle(dirs);
	    for(Dir dir : dirs) {
	      //advance by two steps, so that we will not break through all walls surrounding a cell
	      int nextX = dir.moveX(x, 2);
	      int nextY = dir.moveY(y, 2);
	      if(isValidWall(maze, nextX, nextY)){
	        maze[dir.moveX(x, 1)][dir.moveY(y, 1)] = 0;
	        maze[nextX][nextY] = 0;
	        generate(maze, nextX, nextY);
	      }
	    }
	  }
	  
	  //perfect shuffle
	  public static void shuffle(Dir[] dirs){
	    for(int i=dirs.length; i>=1; i--){
	      int idx = (int)(i*Math.random());
	      Dir temp = dirs[idx];
	      dirs[idx] = dirs[i-1];
	      dirs[i-1] = temp;
	    }
	  }
	  
	  private static boolean isValidWall(int[][] maze, int x, int y) {
	    return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 1;
	  }
	  
	  enum Dir {
	    NORTH(-1, 0), SHOUTH(1, 0), EAST(0, -1), WEST(0, 1);
	    
	    int deltaX;
	    int deltaY;
	    
	    Dir(int deltaX, int deltaY){
	      this.deltaX = deltaX;
	      this.deltaY = deltaY;
	    }
	    
	    public int moveX(int x, int times){
	      return x + times*deltaX;
	    }
	    public int moveY(int y, int times){
	      return y + times*deltaY;
	    }
	  }
}
