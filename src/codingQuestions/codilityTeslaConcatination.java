package codingQuestions;

import java.util.HashSet;
import java.util.Set;

public class codilityTeslaConcatination {

    public static void main(String[] args) {
        String A[] = {"un", "iq", "aef"};
        System.out.println(solution(A));
    }

    public static int solution(String A[]) {
        return helper(A, 0, A.length, "", 0);
    }

    static int helper(String A[], int current, int len, String currString, int max) {
        if (!isUnique(currString)) {
            return 0;
        } else {
            max = Math.max(max, currString.length());
        }
        if (current == len) {
            return max;
        }

        return Math.max(helper(A, current + 1, len, currString, max), helper(A, current + 1, len, currString + A[current], max));
    }

    static  boolean isUnique(String s) {
        if (s.length() > 26) return false;
        boolean[] chars = new boolean[26];
        for (char c: s.toCharArray()) {
            if (chars[c-'a']) return false;
            chars[c-'a'] = true;
        }
        return true;
    }
}
