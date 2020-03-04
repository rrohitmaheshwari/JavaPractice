package codingQuestions;

import java.util.*;
import java.util.stream.Collectors;

public class coupangBigramSynonymExpansion {

    public static void main(String[] args) {

        System.out.println(GenerateBigram("the sofa is too big", Arrays.asList("big,large")));
        System.out.println(GenerateBigram("i am fed up with you", Arrays.asList("fed up,annoyed")));
        System.out.println(GenerateBigram("a b c d e", Arrays.asList("a b,x", "d,y z")));
        System.out.println(GenerateBigram("a b b c d e", Arrays.asList("a b b,x", "y,b b c", "c d e,z")));


    }

    public static List<String> GenerateBigram(String sentence, List<String> synonyms) {
        Set<String> res = new HashSet<>();

        Map<String, String> m = new HashMap<>();

        for (String s : synonyms) {
            String[] temp = s.split(",");
            m.put(temp[0], temp[1]);
            m.put(temp[1], temp[0]);
        }

        helper(sentence, res, m);
        for (Map.Entry<String, String> entry : m.entrySet()) {
            String tempsentence = sentence.replace(entry.getKey(), entry.getValue());
            helper(tempsentence, res, m);
        }

        return res.stream().sorted().collect(Collectors.toList());
    }

    public static void helper(String sentence, Set<String> res, Map<String, String> m) {
        String[] s = sentence.split(" ");

        for (int i = 0; i < s.length - 1; i++) {
            String s1 = s[i];
            String s2 = s[i + 1];
            res.add(s1 + " " + s2);
            if (m.containsKey(s1)) {
                if (!m.get(s1).contains(" ")) {
                    res.add(m.get(s1) + " " + s2);
                    if (m.containsKey(s2)) {
                        if (!m.get(s2).contains(" ")) {
                            res.add(m.get(s1) + " " + m.get(s2));
                        }
                    }
                }
            }
            if (m.containsKey(s2)) {
                if (!m.get(s2).contains(" ")) {
                    res.add(s1 + " " + m.get(s2));
                    if (m.containsKey(s1)) {
                        if (!m.get(s1).contains(" ")) {
                            res.add(m.get(s1) + " " + m.get(s2));
                        }
                    }
                }
            }
        }
    }
}
