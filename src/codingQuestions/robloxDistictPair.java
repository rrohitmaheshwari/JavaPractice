package codingQuestions;

import java.util.*;

public class robloxDistictPair {

    public static void main(String[] args) {
        System.out.println(countPairs(Arrays.asList(5, 7, 9, 13, 11, 6, 6, 3, 3), 12));

    }

    public static int countPairs(List<Integer> arr, long k) {

        int intK = (int) k;

        int n = arr.size();
        HashMap<Integer, Integer> hm = new HashMap<>();
        Set<List<Integer>> result = new HashSet<>();


        arr.forEach((i) ->
                hm.compute(i, (key, val)
                        -> (val == null)
                        ? 1
                        : val + 1)
        );


        arr.forEach((i) -> {
                    if (hm.get(intK - i) != null) {
                        if ((intK - i) == i) {
                            if (hm.get(i) > 1) {
                                result.add(Arrays.asList(i, i));
                            }

                        } else if ((intK - i) < i) {
                            result.add(Arrays.asList((intK - i), i));
                        }
                    }
                }
        );

        System.out.println(result);
        return result.size();

    }
}
