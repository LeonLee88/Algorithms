package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list of coins and a target, how many ways of combination of coins such that
 * sum of coins
 * 1) all the ways
 * 2) number of ways
 *
 * Two way of recursions
 */
public class CombinationSum {
    public List<List<Integer>> allAways(int[] coins, int target){
        List<List<Integer>> res = new ArrayList<>();
        helper(coins, 0, new ArrayList<Integer>(), target, res);
        return res;
    }

    public int allAwaysNum(int[] coins, int target){
        int res = 0;
        res = ways(coins, 0, target);
        return res;
    }

    private void helper(int[] coins, int level, List<Integer> cur, int target, List<List<Integer>> res) {
        if(target == 0){
            res.add(new ArrayList<>(cur));
            return;
        }

        if(target < 0){
            return;
        }
        for(int i =level; i < coins.length; i++) {
            cur.add(coins[i]);
            helper(coins, i, cur, target - coins[i], res);
            cur.remove(cur.size()-1);
        }
    }

    // not working
    private int ways(int[] coins, int level, int target) {
        if(target == 0) {
            return 1;
        }
        if(target < 0 || level == coins.length) {
            return 0;
        }
        int res = 0;
        //res += ways(coins, level, target - coins[level]);
        res += ways(coins, level+1, target - coins[level]);
        res += ways(coins, level+1, target);
        return res;
    }


}
