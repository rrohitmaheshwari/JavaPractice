package codingQuestions;

import java.util.HashMap;
import java.util.Map;

public class IndeedDigitAnagram {

    public static void main(String[] args) {

        System.out.println(digitAnagams(new int[]{1, 1, 1}));

    }

    public static int digitAnagams(int[] a) {
        Map<String, Integer> map = new HashMap();
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            String s = createAnagramHelper(a[i]);
            int count = map.getOrDefault(s, 0);
            result += count;
            map.put(s, count + 1);
        }
        return result;
    }

    private static String createAnagramHelper(int n) {
        int[] cust = new int[10];
        while (n > 0) {
            cust[n % 10]++;
            n /= 10;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < cust.length; i++) {
            res.append(cust[i] + "_");
        }
        return res.toString();
    }


}
