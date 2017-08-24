//package problems;
//
//import problems.datastructures.TreeNode;
//
//public class bstDistance {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int[] nums = new int[]{5,6,3,1,2,4};
//		bstDistance sol = new bstDistance();
//		sol.bstDistance(nums, 2, 4);
//	}
//
//	public int bstDistance(int[] values, int node1, int node2) {
//		TreeNode root = new TreeNode(values[0]);
//		for(){
//
//		}
//	}
//
//	void helper(TreeNode root, int cur, int node1, int node2, int[] temp ){
//
//		if(cur == node1 && root.key > node1) {
//			temp[0]++;
//		}
//
//		if(cur == node2 && root.key < node2) {
//			temp[0]++;
//		}
//
//		if(cur  < root.key){
//			if(root.left != null){
//				helper(root.left, cur, node1, node2, temp);
//			} else {
//				root.left = new TreeNode(cur);
//			}
//		} else {
//			if(root.right != null){
//				helper(root.right, cur, node1, node2, temp);
//			} else {
//				root.right = new TreeNode(cur);
//			}
//		}
//	}
//
//}