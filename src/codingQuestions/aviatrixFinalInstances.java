package codingQuestions;

import java.util.Arrays;
import java.util.List;

public class aviatrixFinalInstances {
    public static void main(String[] args) {
        //Autoscale Policy Problem
        System.out.println(finalInstances(2, Arrays.asList(25, 23, 1, 2, 3, 45, 6, 7, 8, 9, 10, 76, 80)));
        System.out.println(finalInstances(1, Arrays.asList(5, 10, 80)));
        System.out.println(finalInstances(5, Arrays.asList(30, 5, 4, 8, 19, 89)));
    }

    public static int finalInstances(int instances, List<Integer> averageUtil) {
        long temp;
        for (int i = 0; i < averageUtil.size(); i++) {
            if (averageUtil.get(i) > 60) {
                temp = 2 * instances;
                if (temp < 200000000) {
                    instances = (int) temp;
                    i = i + 10;
                }
            } else if (averageUtil.get(i) < 25 && instances != 1) {
                instances = (instances + 1) / 2;
                i = i + 10;
            }
        }
        return instances;

    }


}
