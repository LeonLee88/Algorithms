package problems;

/**
 * Created by leon on 7/30/17.
 */
public class PaintHouses {
    //256. Paint House
    int minCost(int[][] costs){
        if(costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        int[][] dp = new int[n][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for(int i=1; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=0; k < 3; k++) {
                    if(k != j) {
                        dp[i][j] = Math.min(dp[i][j], costs[i][j] + dp[i-1][k]);
                    }
                }
            }
        }

        return Math.min(dp[n-1][2], Math.min(dp[n-1][0], dp[n-1][1]));
    }
}
