package codingQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AmazonAlgorithmSwap {

    public static void main(String[] args) {
        System.out.println(AmazonAlgorithmSwap.howManySwaps(Arrays.asList(5,1,4,2)));

    }

    public static long howManySwaps1(List<Integer> arr){
        long count= 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(j) < arr.get(i)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static long howManySwaps2(List<Integer> arr){
        if(arr.size() ==0)
            return 0;

        long swaps = 0;

        List<Integer> sortedList = arr.stream().sorted().collect(Collectors.toList());

        for(int i = 0 ; i < arr.size() ; i++) {
            int index = Collections.binarySearch(sortedList, arr.get(i));
            int firstIndex = index;
            while(firstIndex > 0) {
                if(sortedList.get(firstIndex).intValue() != sortedList.get(firstIndex - 1).intValue()){
                    break;
                }
                firstIndex--;
            }
            swaps += firstIndex;
            sortedList.remove(firstIndex);
        }

        return swaps;
    }

    public static long howManySwaps(List<Integer> arr){
        if(arr.size() ==0)
            return 0;

        long swaps = 0;

        List<Integer> sortedArr = new ArrayList<>(Collections.nCopies(arr.size(), 0));
        Collections.copy(sortedArr, arr);

        Collections.sort(sortedArr);
        for(int i = 0 ; i < arr.size() ; i++) {
            int firstIndex = Collections.binarySearch(sortedArr, arr.get(i));
            swaps +=  firstIndex;

            if(firstIndex<i)
                swaps--;
//            sortedArr.remove(firstIndex);
        }

        return swaps;
    }



}
