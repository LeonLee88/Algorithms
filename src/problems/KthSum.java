package problems;
import java.util.*;

public class KthSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[]{1,3,5,8,9};
		int[] B = new int[]{2,3,4,7};
		kthSum(A, B, 2);
	}
	
	public static int kthSum(int[] A, int[] B, int k) {
	    
	    PriorityQueue<Cell> pq = new PriorityQueue<Cell>(k, new Comparator<Cell>(){
	      @Override
	      public int compare(Cell c1, Cell c2) {
	        int sum1 = A[c1.x]+B[c1.y];
	        int sum2 = A[c2.x]+B[c2.y];
	        if(sum1 == sum2){
	          return 0;
	        }
	        return sum1 < sum2 ? -1 : 1;
	      }
	    });
	    
	    Cell cur = new Cell(0, 0);
	    boolean[][] visited = new boolean[A.length][B.length];
	    visited[0][0] = true;
	    pq.offer(cur);
	    while(k>0){
	      cur = pq.poll();
	      if(cur.x+1 < A.length && !visited[cur.x+1][cur.y]){
	        pq.offer(new Cell(cur.x+1, cur.y));
	        visited[cur.x+1][cur.y] = true;
	      }
	      if(cur.y+1 < B.length && !visited[cur.x][cur.y+1]){
	        pq.offer(new Cell(cur.x, cur.y+1));
	        visited[cur.x][cur.y+1] = true;
	      }
	      k--;
	    }
	    return A[cur.x]+B[cur.y];
	  }
	  
	  static class Cell {
	    int x; // index in A
	    int y; // index in B
	    public Cell(int x, int y){
	      this.x = x;
	      this.y = y;
	    }
	  }

}
