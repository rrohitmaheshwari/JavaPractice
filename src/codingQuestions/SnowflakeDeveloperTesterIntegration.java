package codingQuestions;

import java.util.*;
import java.util.stream.IntStream;

public class SnowflakeDeveloperTesterIntegration {

    public static void main(String[] args) {

//        System.out.println(formTeam(2,2,Arrays.asList(2,5,7,11)));
//        System.out.println(formTeam(3,4,Arrays.asList(1,2,3,4)));
//        System.out.println(formTeam(3, 2, Arrays.asList(4)));
//        System.out.println(formTeam(19, 47, Arrays.asList(124)));
        System.out.println(formTeam(19, 47, Arrays.asList(29, 124, 77, 10, 28, 101, 78, 93, 15, 7, 106, 40, 65, 118, 98, 127, 53, 27, 83, 94, 34, 110, 70, 38, 5, 35, 61, 51, 72, 22, 81, 108, 67, 80, 18, 99, 63, 95, 23, 3, 88, 26, 75, 31, 2, 71, 9, 42, 114, 91, 66, 105, 112, 33, 20, 92, 85, 30, 62, 89, 16, 24, 1, 84, 32, 123, 100, 57, 13, 90, 122, 73, 39, 116, 25, 37, 64, 113, 86, 8, 69, 87, 41, 59, 125, 79, 44, 126, 58, 48, 4, 47, 119, 36, 49, 111, 121, 52, 115, 56, 74, 43, 107)));
    }

    public static List<Integer> formTeam(int d, int t, List<Integer> q) {
        List<Integer> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        Integer max = q
                .stream()
                .mapToInt(v -> v)
                .max().orElseThrow(NoSuchElementException::new);
        helper(d, t, max, d, t, map);

        for (int Q : q) {
            double i = helper(d, t, Q, d, t, map);

            res.add((int) (i % 1000_000_007));
        }
        return res;

    }

    public static int helper(int d, int t, int Q, int D, int T, HashMap<String, Integer> map) {

        StringBuilder s = new StringBuilder();
        s.append(d).append('#').append(t).append('#').append(Q);
        if (map.containsKey(s.toString())) {
            return map.get(s.toString());
        }
        int temp;
        if (Q == 0) {
            map.put(s.toString(), 1);
            return 1;
        }
        if (d == 1 && t > 1) {
            temp = helper(D, t - 1, Q - 1, D, T, map);
            map.put(s.toString(), temp);
            return temp;
        }
        if (t == 1 && d > 1) {
            temp = helper(d - 1, T, Q - 1, D, T, map);
            map.put(s.toString(), temp);
            return temp;

        }
        if (d <= 1 && t <= 1) {
            map.put(s.toString(), 0);
            return 0;
        }
        temp = helper(d - 1, T, Q - 1, D, T, map) % 1000_000_007 + helper(D, t - 1, Q - 1, D, T, map) % 1000_000_007;
        map.put(s.toString(), temp);
        return temp;

    }

}
