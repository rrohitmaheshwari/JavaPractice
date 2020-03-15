package codingQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ellemePrizonBar {

    public static void main(String[] args) {
//        4
//        12
//        4

        System.out.println(prison(3, 3, Arrays.asList(2), Arrays.asList(2)));
        System.out.println(prison(3, 2, Arrays.asList(1, 2, 3), Arrays.asList(1, 2)));
        System.out.println(prison(2, 2, Arrays.asList(1), Arrays.asList(2)));
//        System.out.println(prison(3, 3, Arrays.asList(2), Arrays.asList(2)));
    }

    static long prison(int n, int m, List<Integer> h, List<Integer> v) {


        List<Integer> l1 = new ArrayList<>();
        for (int i = 0; i <= n + 1; i++) {
            if (!h.contains(i)) {
                l1.add(i);
            }
        }

        List<Integer> l2 = new ArrayList<>();
        for (int i = 0; i <= m + 1; i++) {
            if (!v.contains(i)) {
                l2.add(i);
            }
        }

        int mh = 1;
        for (int i = 0; i < l1.size() - 1; i++) {
            if (mh < (l1.get(i + 1) - l1.get(i))) {
                mh = l1.get(i + 1) - l1.get(i);
            }
        }

        int mv = 1;
        for (int i = 0; i < l2.size() - 1; i++) {
            if (mv < (l2.get(i + 1) - l2.get(i))) {
                mv = l2.get(i + 1) - l2.get(i);
            }
        }

        return (long) mh * (long) mv;

    }
}
