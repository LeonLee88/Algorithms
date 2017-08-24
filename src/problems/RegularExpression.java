package problems;

/**
 * Created by leon on 7/17/17.
 */
public class RegularExpression {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i=1; i <= p.length(); i++) {
            if(p.charAt(i-1) == '*') {
                dp[0][i] = dp[0][i-2];
            }
        }
        for(int i = 1; i < dp.length; i ++) {
            for(int j = 1; j < dp[0].length; j ++) {
                if(p.charAt(j-1) != '*') {
                    if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') {
                        dp[i][j] = dp[i-1][j-1];
                    }
                } else if(p.charAt(j-2) == '.' || s.charAt(i-1) == p.charAt(j-2)) {
                    // 1 : a* match 0 a
                    // 2 : a* match >= 1 a
                    dp[i][j] = dp[i][j-2] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i][j-2];
                }

            }
        }
        return dp[s.length()][p.length()];
    }
}
