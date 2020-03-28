package codingQuestions;

import java.util.HashSet;
import java.util.Set;

public class coupangPerfectNumber {

    public static void main(String[] args) {

        System.out.println(PerfectNumbers(1000));
    }

    public static int PerfectNumbers(int N) {

        int l = (int) Math.sqrt(N);
        int num = 1;

        Set<Integer> s = new HashSet<>();
        Set<String> seen = new HashSet<>();
        for (int i = 2; i <= l; i++) {

            int j = 2;
            num = 0;
            while (num < N) {
                num = (int) Math.pow(i, j);
                s.add(num);
                j++;
            }
        }

        s.add(1);

//        System.out.println(s);
        int res = 0;


        for (int k = 1; k <= N; k++) {

            for (int i : s) {
                if (s.contains(k - i)) {

                    if ((k - i) < i) {
                        if (!seen.contains((k - i) + " " + i)) {
                            res++;
                            seen.add((k - i) + " " + i);
//                            System.out.println(k + " - " + (k - i) + " " + i);
                        }

                    } else {

                        if (!seen.contains(i + " " + (k - i))) {
                            res++;
                            seen.add(i + " " + (k - i));
//                            System.out.println(k + " - " + i + " " + (k - i));
                        }

                    }
                    break;
                }
            }

        }
//        System.out.println(seen);

        return res;
    }
}
