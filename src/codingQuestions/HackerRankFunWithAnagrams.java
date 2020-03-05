package codingQuestions;

import java.lang.reflect.Array;
import java.util.*;

public class HackerRankFunWithAnagrams {

    public static void main(String[] args) {
        System.out.println(funWithAnagrams(Arrays.asList("code", "doce", "ecod", "framer", "frame")));
        System.out.println(funWithAnagrams(Arrays.asList("code", "aaagmnrs", "anagrams", "doce")));
        System.out.println(funWithAnagrams(Arrays.asList("poke", "pkoe", "okpe", "ekop")));
    }

    private static List<String> funWithAnagrams(List<String> text) {

        if (text.size() < 2) {
            return text;
        }


        Set<String> set = new HashSet<>();
        List<String> res = new ArrayList<>();

        for (int i = 0; i < text.size(); i++) {
            String s = helper(text.get(i)).toString();
            if (!set.contains(s)) {
                set.add(s);
                res.add(text.get(i));
            }
        }
        Collections.sort(res);

        return res;

    }

    static StringBuilder helper(String s) {
        StringBuilder res = new StringBuilder();
        int[] count = new int[26];
        int i;
        for (i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (i = 0; i < 26; i++) {
            res.append((char) ('a' + i) + "" + count[i]);
        }

        return res;

    }

//
//    static boolean isAnagram(String str1, String str2) {
//        if (str1.length() != str2.length())
//            return false;
//
//        int[] count = new int[26];
//        int i;
//
//
//        for (i = 0; i < str1.length(); i++) {
//            count[str1.charAt(i) - 'a']++;
//            count[str2.charAt(i) - 'a']--;
//        }
//
//
//        for (i = 0; i < 26; i++)
//            if (count[i] != 0)
//                return false;
//        return true;
//    }
}
