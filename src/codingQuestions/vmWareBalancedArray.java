package codingQuestions;

import java.util.Arrays;
import java.util.List;

public class vmWareBalancedArray {
    public static void main(String[] args) {

        System.out.println(balancedSum(Arrays.asList(1,2,3,3)));
        System.out.println(balancedSum(Arrays.asList(1,2,1)));
        System.out.println(balancedSum(Arrays.asList(1,2,3,4,6)));

    }
    public static int balancedSum(List<Integer> arr){
        int sum = 0, leftsum = 0;
        for (int x: arr) sum += x;
        for (int i = 0; i < arr.size(); ++i) {
            if (leftsum == sum - leftsum - arr.get(i)) return i;
            leftsum += arr.get(i);
        }
        return -1;
    }
}
