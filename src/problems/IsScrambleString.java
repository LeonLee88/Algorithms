package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by leon on 7/22/17.
 */
public class IsScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        int len = s1.length();
        if (!isAnagram(s1, s2)) return false;
        for (int i = 1; i < len; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble(s1.substring(i), s2.substring(i)) ||
                    isScramble(s1.substring(0, len - i), s2.substring(i)) &&
                            isScramble(s1.substring(len - i), s2.substring(0, i))) {
                return true;
            }
        }
        return false;
    }

    private boolean isAnagram(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            Integer count = map.get(s1.charAt(i));
            map.put(s1.charAt(i), count == null ? 1 : count + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            Integer count = map.get(s2.charAt(i));
            if (count == null) return false;
            if (count == 1) {
                map.remove(s2.charAt(i));
            } else {
                map.put(s2.charAt(i), count - 1);
            }
        }
        return map.size() == 0;
    }

    public boolean isScrambleII(String s1, String s2) {
        int len = s1.length();
        boolean[][][] dp = new boolean[len][len][len+1];

        for(int i=0; i< len; i++) {
            for(int j=0; j < len; j++){
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for(int curLen = 1; curLen <= len; curLen++) {
            for(int i = 0; i + curLen <= len; i++) {
                for(int j=0; j + curLen <= len; j++){
                    for(int k = 1; k < curLen; k++) {
                        if(dp[i][j][k] && dp[i+k][j+k][curLen-k] ||
                                dp[i][j+curLen-k][k] && dp[i+k][j][curLen-k]) {
                            dp[i][j][curLen] = true;
                            break;
                        }
                    }
                }
            }
        }
        return  dp[0][0][len];
    }
}
