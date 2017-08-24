package problems;

import problems.datastructures.TreeNode;

/**
 * Created by leon on 8/6/17.
 */
public class HouseRobberIII {
    public int rob(TreeNode root) {
        int[] max = dfs(root);
        return Math.max(max[0], max[1]);
    }

    int[] dfs(TreeNode root) {
        int[] max = new int[2];
        if(root == null) {
            return max;
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        max[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        max[1] = Math.max(left[0], right[0]) + root.key;
        return max;
    }
}
