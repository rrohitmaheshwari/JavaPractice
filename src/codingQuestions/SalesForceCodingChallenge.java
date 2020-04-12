package codingQuestions;

import java.util.Arrays;
import java.util.List;

public class SalesForceCodingChallenge {
    public static void main(String[] args) {
        System.out.println(minimumMoves(Arrays.asList(1234,4321),Arrays.asList(2345,3214)));
        System.out.println(minimumMoves(Arrays.asList(2468),Arrays.asList(8642)));
    }

    public static int minimumMoves(List<Integer> arr1, List<Integer> arr2){
        int diff = 0;
        for(int i=0;i<arr1.size();i++){
          diff += diffHelper(arr1.get(i),arr2.get(i));
        }
        return diff;
    }

    private static int diffHelper(int a,int b){
        int res=0;
        while(a>0){
            res += Math.abs((a%10) - (b%10));
            a=a/10;
            b=b/10;
        }
        return res;
    }
}
