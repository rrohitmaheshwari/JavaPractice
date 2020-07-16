package codingQuestions;

import java.util.*;

public class SnowflakeLargestArea {

    public static void main(String[] args) {
//        System.out.println(largestArea(
//                Arrays.asList(
//                        Arrays.asList(1, 1, 1, 1, 1),
//                        Arrays.asList(1, 1, 1, 0, 0),
//                        Arrays.asList(1, 1, 1, 0, 0),
//                        Arrays.asList(1, 1, 1, 0, 0),
//                        Arrays.asList(1, 1, 1, 1, 1)
//                )));

//        System.out.println(largestArea(
//                Arrays.asList(
//                        Arrays.asList(0,1,1),
//                        Arrays.asList(1, 1, 0),
//                        Arrays.asList(1, 0,1)
//                )));

        System.out.println(largestArea(
                Arrays.asList(
                        Arrays.asList(1,1,1),
                        Arrays.asList(1, 1, 0),
                        Arrays.asList(1, 0,1)
                )));
    }

    public static int largestArea(List<List<Integer>> sample) {
        int rows = sample.size(), cols = rows > 0 ? sample.get(0).size() : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (sample.get(i-1).get(j-1) == 1){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen ;
    }


}
