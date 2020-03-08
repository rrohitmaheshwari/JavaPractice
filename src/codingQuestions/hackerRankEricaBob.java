package codingQuestions;

public class hackerRankEricaBob {

    public static void main(String[] args) {
        System.out.println(winner("EHH", "EME"));
        System.out.println(winner("", ""));
        System.out.println(winner(null, null));
    }

    public static String winner(String erica, String bob) {
        if ((erica == null && bob == null) || (erica.length() == 0 && bob.length() == 0)) {
            return "Tie";
        }
        int res = 0;

        for (int i = 0; i < erica.length(); i++) {
            res += (value(erica.charAt(i)) - value(bob.charAt(i)));
        }

        if (res > 0) {
            return "Erica";
        } else if (res < 0) {
            return "Bob";
        } else {
            return "Tie";
        }

    }

    public static int value(char ch) {
        if (ch == 'E') {
            return 1;
        } else if (ch == 'M') {
            return 3;
        } else {
            return 5;
        }
    }
}
