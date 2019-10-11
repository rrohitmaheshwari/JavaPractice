package hackerRankProblems;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HashTableRansomNote {
    public static void main(String[] args) {
        String[] magazine = {"two", "times", "three", "is", "not", "four"};
        checkMagazine(magazine, new String[]{"two", "times", "two", "is", "four"});
        checkMagazine(magazine, new String[]{"two", "times", "four"});

    }

    static void checkMagazine(String[] magazine, String[] note) {
        if (note.length > magazine.length) {
            System.out.println("No");
            return;
        }

        Map<String, Long> map =
                Stream.of(magazine).collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));            //word frequency

        long temp;
        for (String s : note) {

            if (!map.containsKey(s)) {
                System.out.println("No");
                return;
            } else {
                temp = map.get(s);
                if (temp == 0) {
                    System.out.println("No");
                    return;
                }
                map.put(s, temp - 1);
            }
        }
        System.out.println("Yes");

    }
}
