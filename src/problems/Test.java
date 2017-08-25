package problems;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by leon on 7/9/17.
 */
public class Test {
    public static void main(String[] args) {
//        alien dictionary
//        AlienDictionary sol = new AlienDictionary();
//        String[] words = {"wrta","wrf","er","ett","rfttb"};
//        String[] words = {"wrta","wrf","er","ett","rfttb", "rfe"};
//        sol.alienOrder(words);

        // Longest valid parenthesis
//        LongestValidParentheses sol = new LongestValidParentheses();
//        sol.method1("())");

//        RegularExpression sol = new RegularExpression();
//        sol.isMatch("aab","c*a*b");
//        sol.isMatch("aasdfasdfasdfasdfas","aasdf.*asdf.*asdf.*asdf.*s");

//        IsScrambleString sol = new IsScrambleString();
//        sol.isScrambleII("abcd","bcad");

//        PaintHouses sol = new PaintHouses();
//        int[][] costs = {{1,4,5},{2,3,3},{5,3,1},{1,3,1}};
//        sol.minCost(costs);

//        CombinationSum sol = new CombinationSum();
//        int[] a = {2,3, 5, 6, 8};
//        sol.allAwaysNum(a, 20);

//        CourseSchedule1 sol = new CourseSchedule1();
//        int[][] a = {{0,1}, {1, 0}};
//        sol.canFinish(2, a);

//        FactorsCombination sol = new FactorsCombination();
//        sol.getFactors(12);

//        OutOfBoundaryPaths sol = new OutOfBoundaryPaths();
//        sol.findPaths(2,2,2,0,0);

//        DecodeString sol = new DecodeString();
//        sol.decodeString("0[a3[c]]");

        WindowMedian sol = new WindowMedian();
        int[] a = {4,2, 8, 5, 9, -1};
        sol.getMedians1(a, 4);

    }

}
