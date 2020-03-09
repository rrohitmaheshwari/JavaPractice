package codingQuestions;

import java.util.*;

public class twitterSubPalindrome {

    public static void main(String[] args) {

        System.out.println(palindrome("mokkori"));

    }

        static int palindrome(String s) {
            int n = s.length();
            Set<String> res = new HashSet<>();


            int[][] dp = new int[2][n + 1];


            s = "#" + s + "$";

            for (int j = 0; j <= 1; j++) {
                int index = 0;
                dp[j][0] = 0;

                int i = 1;
                while (i <= n) {

                    while (s.charAt(i - index - 1) == s.charAt(i +
                            j + index))
                        index++;
                    dp[j][i] = index;
                    int k = 1;
                    while ((dp[j][i - k] != index - k) && (k < index)) {
                        dp[j][i + k] = Math.min(dp[j][i - k],
                                index - k);
                        k++;
                    }
                    index = Math.max(index - k, 0);
                    i += k;
                }
            }


            s = s.substring(1, s.length() - 1);


            res.add(s.substring(0, 1));

            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= 1; j++)
                    for (int k = dp[j][i]; k > 0; k--) {

                        res.add(s.substring(i - k - 1, i - k - 1
                                + 2 * k + j));
                    }


                res.add(s.substring(i, i + 1));
            }


            return res.size();
        }
}
