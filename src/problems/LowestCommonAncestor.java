package problems;

import problems.datastructures.TreeNode;

public class LowestCommonAncestor {

	public static void main(String[] args) {
		LowestCommonAncestor sol = new LowestCommonAncestor();
		TreeNode a = new TreeNode(5);
		a.left = new TreeNode(9);
		a.right = new TreeNode(12);
		TreeNode two = a.left.left = new TreeNode(2);
		TreeNode notExists = new TreeNode(0);
		TreeNode result = sol.lowestCommonAncestorIII(a, a.left, two);
		a.right = new TreeNode(13);
	}

	public TreeNode lowestCommonAncestorIII(TreeNode root, TreeNode one,
			TreeNode two) {
		boolean[] found = new boolean[2];
		TreeNode result = helper(root, one, two, found); // found[0] means node one found, found[1] means node two found
		return found[0] == true && found[1] == true ? result : null;
	}

	public TreeNode helper(TreeNode root, TreeNode one, TreeNode two,
			boolean[] found) {
		if (root == null) {
			return null;
		}

		if (root == one) {
			found[0] = true;
		}
		if (root == two) {
			found[1] = true;
		}
    // Can't stop diving down, since the node is not guaranteed exists. We have to check all node unless we found them
    
		TreeNode left = helper(root.left, one, two, found);
		TreeNode right = helper(root.right, one, two, found);
		if (left != null && right != null && found[0] == true && found[1] == true) { // found node one and node two, and they are in different subtrees
			return root;
		}
		if(root == one || root == two){ // current node is one of the input nodes, return it
			return root;
		}
		return left != null ? left : right;
	}

}
