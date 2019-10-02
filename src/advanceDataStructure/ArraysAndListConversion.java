package src.advanceDataStructure;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArraysAndListConversion {

    public static void main(String[] args) {
        //1 Convert `List<String>` to `List<Integer>`
        List<String> l1 = Arrays.asList("1", "2", "3");
        List<Integer> r1 = l1.stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.println("1: " + r1);

        //2 Convert `List<String>` to `int[]`
        int[] r2 = l1.stream().mapToInt(Integer::parseInt).toArray();
        System.out.println("2: " + Arrays.toString(r2));

        //3 Convert `String[]` to `List<Integer>`
        String[] a1 = {"4", "5", "6"};
        List<Integer> r3 = Stream.of(a1).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println("3: " + r3);

        //4 Convert `String[]` to `int[]`
        int[] r4 = Stream.of(a1).mapToInt(Integer::parseInt).toArray();
        System.out.println("4: " + Arrays.toString(r4));

        //5 Convert `String[]` to `List<Double>`
        List<Double> r5 = Stream.of(a1).map(Double::parseDouble).collect(Collectors.toList());
        System.out.println("5: " + r5);

        //6 (bonus) Convert `int[]` to `String[]`
        int[] a2 = {7, 8, 9};
        String[] r6 = Arrays.stream(a2).mapToObj(Integer::toString).toArray(String[]::new);
        System.out.println("6: " + Arrays.toString(r6));
    }

}
