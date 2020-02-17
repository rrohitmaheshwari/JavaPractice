package codingQuestions;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class hackerRankCountingPair {
    public static void main(String[] args) {
        System.out.println(countPairs(Arrays.asList(1,1,2,2,3,3),1));
    }

    public static int countPairs(List<Integer> numbers, int k){

        Set<Integer> numbersSet = new HashSet<>(numbers);
        return (int)numbersSet.stream()
                .filter(i -> numbersSet.contains(i - k))
                .count();

    }
}
