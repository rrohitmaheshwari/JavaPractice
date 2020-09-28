package codingQuestions;

import java.util.*;
import java.util.stream.*;

public class roht {

    public static void main(String[] args) {

        List<Integer> lengths = new ArrayList();
        //   20, 40, 21, 20, 20, 20, 20, 20, 20
        lengths.add(20);
        lengths.add(40);
        lengths.add(21);
        lengths.add(20);
        lengths.add(20);
        lengths.add(20);
        lengths.add(20);
        lengths.add(20);
        lengths.add(20);

        System.out.println(maxProfit(25, 1, lengths));
    }
    public static int maxProfit(int costPerCut, int salePrice, List<Integer> lengths) {
        int maxLength = lengths.stream().mapToInt(i -> i).max().orElse(0);
        return IntStream.rangeClosed(1, maxLength).map(l -> maxProfit(costPerCut, salePrice, lengths, l)).max().orElse(0);
    }

    private static int maxProfit(int costPerCut, int salePrice, List<Integer> lengths, int len) {
        int profit = 0;
        for (Integer rod : lengths) {
            profit += maxProfitOne(costPerCut, salePrice, rod, len);
        }
        return profit;
    }

    private static int maxProfitOne(int costPerCut, int salePrice, int length, int requiredLen) {
        int totalCuts = (length - 1) / requiredLen;
        int effectiveLength = length / requiredLen * requiredLen * salePrice;
        return effectiveLength - (totalCuts * costPerCut);
    }
}
