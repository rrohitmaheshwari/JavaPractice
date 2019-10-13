package codingQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class primeString {
    public static void main(String[] args) {
        System.out.println(primeStringCreator("ABc"));

    }

    public static String primeStringCreator(String s) {
        if (s.length() == 0) {
            return s;
        }
        ArrayList<Integer> primesCaps = new ArrayList<Integer>();
        ArrayList<Integer> primesSmall = new ArrayList<Integer>();

        String sourceCap = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String sourceSmall = "abcdefghijklmnopqrstuvwxyz";

        boolean[] helper = new boolean[52];
        int index = 0;
        for (char c : sourceCap.toCharArray()) {
            helper[index++] = isPrime(c);
        }

        for (char c : sourceSmall.toCharArray()) {
            helper[index++] = isPrime(c);
        }

        for (int i = 0; i < 26; i++) {
            if (helper[i] == true) {
                primesCaps.add('A' + i);
            }
        }

        for (int i = 26; i < 52; i++) {
            if (helper[i] == true) {
                primesSmall.add('a' + i - 26);
            }
        }

        Collections.sort(primesCaps);
        Collections.sort(primesSmall);


        Map<Character, Character> hm = new HashMap<>();

        for (char c : sourceCap.concat(sourceSmall).toCharArray()) {
            if (isPrime(c)) {
                hm.put(c, c);
            } else {

                ArrayList<Integer> primes;
                if (c <= 'Z') {
                    primes = primesCaps;

                } else {
                    primes = primesSmall;
                }

                int nearest = 0;
                for (int ind = 0; ind < primes.size(); ind++) {
                    if (primes.get(ind) <= c) {
                        nearest = ind;
                    } else {
                        break;
                    }
                }
                if (nearest != primes.size() - 1 && Math.abs(primes.get(nearest) - c) > Math.abs(primes.get(nearest + 1) - c)) {
                    nearest = nearest + 1;
                }


                hm.put(c, (char) ((int) primes.get(nearest)));

            }
        }


        StringBuilder res = new StringBuilder();
        for (char a : s.toCharArray()) {
            res.append(hm.get(a));
        }

        return res.toString();
    }


    static boolean isPrime(int num) {


        if (num % 2 == 0 || num % 3 == 0) return false;

        for (int i = 5; i * i <= num; i = i + 6)
            if (num % i == 0 || num % (i + 2) == 0)
                return false;

        return true;
    }


}
