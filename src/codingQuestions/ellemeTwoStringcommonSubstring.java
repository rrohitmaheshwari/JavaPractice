package codingQuestions;

import java.util.Arrays;
import java.util.List;

public class ellemeTwoStringcommonSubstring {

    public static void main(String[] args) {
        commonSubstring(Arrays.asList("hello","hi"), Arrays.asList("world","bye"));
    }

    public static void commonSubstring(List<String> a, List<String> b) {
        for (int i = 0; i < a.size(); i++) {
            if (helper(a.get(i), b.get(i))) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    static boolean helper(String s1, String s2) {
        boolean b[] = new boolean[26];
        Arrays.fill(b, false);

        for (int i = 0; i < s1.length(); i++)
            b[s1.charAt(i) - 'a'] = true;

        for (int i = 0; i < s2.length(); i++)
            if (b[s2.charAt(i) - 'a'])
                return true;

        return false;
    }
}
