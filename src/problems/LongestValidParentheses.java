package problems;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by leon on 7/15/17.
 */
public class LongestValidParentheses {
    public int method1(String s) {
        if (s == null || s.length() < 2) return 0;
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i - 2) >= 0 ? dp[i - 2] + 2 : 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] -1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1] - 2) >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }

    public int method2(String s) {
        if (s == null || s.length() < 2) return 0;
        int max = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.offer(-1);
        for(int i =0 ; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.offer(i);
            } else {
                stack.poll();
                if(stack.isEmpty()) {
                    stack.offer(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
