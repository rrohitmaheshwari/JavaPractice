package codingQuestions;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class findMinimumGroup {

    public static void main(String[] args) {
        System.out.println(minimumGroups(Arrays.asList(-1, 8, 6, 0, 7, 3, 8, 9, -1, 6)));
        System.out.println(minimumGroups(Arrays.asList(-1, 0, 1)));
    }

    public static int minimumGroups(List<Integer> predators) {
        int max = 1;
        int len = predators.size();
        for (var i = 0; i < len; i++) {
            int a = i;
            int cntr = 1;
            while (predators.get(a) > -1 && predators.get(a) < len && cntr < len) {
                a = predators.get(a);
                cntr++;
            }

            if (cntr > max)
                max = cntr;
        }
        return max;
    }


}
