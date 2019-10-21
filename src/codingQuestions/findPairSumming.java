package codingQuestions;

import java.util.HashMap;
import java.util.Map;

public class findPairSumming {
    public static void main(String[] args) {
        int[] a = {2, 4, 7, 5, 3, 5, 8, 5, 1};
//        int[] a = {15, 8, 8, 2, 6, 4, 1, 7};
//        System.out.println(findPairsSummingTok(a, 2, 8));
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


        System.out.println(map);

        for (int i = 0; i < a.length - m; i++) {


            if (map.containsKey(a[i + m])) {
                map.put(a[i + m], map.get(a[i + m]) + 1);
            } else {
                map.put(a[i + m], 1);
            }
            System.out.println(map);


            for (int l = i; l < i + m; l++) {


                if (map.containsKey(k - a[l]) && map.get(k - a[l]) > 0) {

                    if (k - a[l] == a[l] && map.get(k - a[l]) > 1) {
                        res++;
                        break;
                    } else if (k - a[l] != a[l]) {
                        res++;
                        break;
                    }


                }
            }


            map.put(a[i], map.get(a[i]) - 1);


        }

        return res;
    }
}
