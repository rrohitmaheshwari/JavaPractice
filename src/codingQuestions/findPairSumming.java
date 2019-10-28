package codingQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class findPairSumming {
    public static void main(String[] args) {
        int[] a = {2, 4, 7, 5, 3, 5, 8, 5, 1, 7};
        System.out.println(findPairsSummingTok(a, 4, 10));

    }

    static int findPairsSummingTok(int[] a, int m, int k) {
        int res = 0;


        Map<Integer, Integer> map = new HashMap<>();


        for (int j = 0; j < m - 1; j++) {
            if (map.containsKey(a[j])) {
                map.put(a[j], map.get(a[j]) + 1);
            } else {
                map.put(a[j], 1);
            }
        }


//        System.out.println(map);

        for (int i = 0; i <= a.length - m; i++) {


            if (map.containsKey(a[i + m - 1])) {
                map.put(a[i + m - 1], map.get(a[i + m - 1]) + 1);
            } else {
                map.put(a[i + m - 1], 1);
            }
//            System.out.print("i: " + i + " [ ");
//            map.forEach((key, val) -> {
//                if (val > 0)
//                    System.out.print(" " + key + "=" + val + " ");
//            });
//            System.out.println(" ]");


            for (int l = i; l < i + m; l++) {


                if (map.containsKey(k - a[l]) && map.get(k - a[l]) > 0) {

                    if (k - a[l] == a[l] && map.get(k - a[l]) > 1) {
                        res++;
//                        System.out.println("i ->" + i);
                        break;
                    } else if (k - a[l] != a[l]) {
                        res++;
//                        System.out.println("i-->" + i);
                        break;
                    }


                }
            }


            map.put(a[i], map.get(a[i]) - 1);


        }

        return res;
    }
}
