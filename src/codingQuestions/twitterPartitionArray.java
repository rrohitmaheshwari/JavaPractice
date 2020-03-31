package codingQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class twitterPartitionArray {
    public static void main(String[] args) {
        System.out.println(partitionArrayUnique(2, Arrays.asList(1, 2, 3, 4))); // true
        System.out.println(partitionArrayUnique(3, Arrays.asList(1, 2, 3, 1, 2, 3, 1, 2, 2))); // false

    }

    public static boolean partitionArrayUnique(int k, List<Integer> numbers) {
        if (numbers.size() % k != 0) {
            return false;
        }

        HashMap<Integer, Integer> m = new HashMap<>();
        int maxCount = 0;
        for (int num : numbers) {
            m.put(num, m.getOrDefault(num, 0) + 1);
            if (m.get(num) > maxCount) {
                maxCount = m.get(num);
            }
        }

        return maxCount <= (numbers.size() / k);
    }
}
