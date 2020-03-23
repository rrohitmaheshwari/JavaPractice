package codingQuestions;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class HackerRankVeritasRollingString {

    public static void main(String[] args) {
//        System.out.println(rollingString("abc", Arrays.asList("0 0 L", "2 2 L", "0 2 R")));
        System.out.println(rollingString("rbsshsjxdfilebxwbctoayaxzfbjbkrxirimqpzwmshlpjhtazhbuxhwadlptoy",
                Arrays.asList("15 57 R", "33 35 L", "13 44 R", "23 50 L", "45 50 L", "3 22 R", "32 49 R", "2 56 R", "0 62 L", "16 53 R", "39 47 R", "47 61 R", "15 20 L", "2 39 L", "41 46 R", "33 45 L", "26 58 L", "14 49 R", "50 60 R", "10 36 R", "3 55 L", "22 30 L", "22 45 R", "11 61 R", "19 49 R", "11 38 L", "0 2 L", "21 36 R", "31 41 R", "19 43 L", "30 48 L", "6 54 R", "27 54 L", "43 56 R", "5 11 R", "9 31 R", "7 21 R", "13 34 L", "25 30 L", "23 29 L", "49 50 L", "16 62 L", "35 55 L", "0 19 L", "7 15 L", "23 25 R", "23 57 L", "51 52 L", "9 48 L", "24 48 R", "8 35 R", "17 41 R", "39 62 R", "4 26 L", "30 32 L", "12 59 L", "31 56 R", "0 42 L", "25 39 R", "5 26 R", "20 50 L", "50 50 L", "21 50 L", "54 62 L", "8 15 L")));
    }

    private static String rollingString(String s, List<String> operations) {

        int[] rotate = new int[s.length()];
        for (String str : operations) {
            String[] ch = str.split(" ");
            int dir = 1;

            if (ch[2].equals("L")) {
                dir = -1;
            }

            for (int i = Integer.parseInt(ch[0]); i <= Integer.parseInt(ch[1]); i++) {
                rotate[i] += dir;
            }
        }

        StringBuilder res = new StringBuilder(s);

        for (int i = 0; i < res.length(); i++) {
            int index = rotate[i];

            while (index < 0) {
                index += 26;
            }

            char ch = (char) (((int) res.charAt(i) +
                    index - 97) % 26 + 97);

            res.setCharAt(i, ch);

        }

        return res.toString();
    }
}
