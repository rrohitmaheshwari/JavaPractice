package codingQuestions;

import java.util.HashSet;
import java.util.Set;

public class codilityTeslaConcatination {

    public static void main(String[] args) {
        String A[] = {"co", "dil", "ity"};
        System.out.println(solution(A));
    }

    static int max;

    public static int solution(String A[]) {

        int len = A.length;
        helper(A, 0, len, "");
        return max;
    }

    static void helper(String A[], int current, int len, String currString) {
        if (current == len) {
            return;
        }
        if (!isUnique(currString)) {
            return;
        }
        if (max < currString.length()) {
            max = currString.length();
        }
        helper(A, current + 1, len, currString + A[current]);
        helper(A, current + 1, len, currString);
    }

    static boolean isUnique(String s) {
        if (s.length() > 26) return false;
        boolean[] chars = new boolean[26];
        int ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i) - 'a';
            if (chars[ch]) return false;
            chars[ch] = true;
        }
        return true;
    }
}
