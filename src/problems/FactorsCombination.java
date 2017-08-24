package problems;

import java.util.*;

/**
 * Created by leon on 8/12/17.
 */
public class FactorsCombination {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new LinkedList<>();
        helper(n, 2, new LinkedList<>(), res);
        return res;
    }

    public void helper(int n, int start, List<Integer> cur, List<List<Integer>> res) {
        if(n <= 1) {
            if(cur.size() > 1) {
                res.add(new LinkedList<>(cur));
            }
            return;
        }
        for(int i = start; i <= n; i++) {
            if(n % i == 0) {
                cur.add(i);
                helper(n/i, i, cur, res);
                cur.remove(cur.size()-1);
            }
        }
    }

    // not working yet, dfs + mem
    public List<List<Integer>> dfsMem(int n, Map<Integer, List<List<Integer>>> mem) {
        if(n == 1) {
            return new LinkedList<>();
        }
        if(n == 2 || n == 3) {
            List<List<Integer>> res = new LinkedList<>();
            List<Integer> e = new LinkedList<>();
            e.add(n);
            res.add(e);
            return res;
        }
        if(mem.containsKey(n)) {
            return new LinkedList<>(mem.get(n));
        }
        List<List<Integer>> res = new LinkedList<>();
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                List<List<Integer>> temp = helper(n/i, mem);
                for(List<Integer> e : temp) {
                    e.add(0, i);
                }
                res.addAll(new LinkedList<List<Integer>>(temp));
            }
        }
        mem.put(n, res);
        return res;
    }
}
