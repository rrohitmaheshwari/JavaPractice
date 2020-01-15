package codingQuestions;

public class quoraRemoveOneDigit {

    public static void main(String[] args) {
        System.out.println(removeOneDigit("ab12c", "ab24z"));
        System.out.println(removeOneDigit("ab12c", "1zz456"));
    }

    public static int removeOneDigit(String s, String t) {



        return (helper(s, t, true) + helper(t, s, false));


    }

    public static  int helper(String s, String t, boolean flag) {
        int ways = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sbs = new StringBuilder(s);
            if (Character.isDigit(s.charAt(i))) {
                sbs.deleteCharAt(i);
                String sub = sbs.toString();
                if (flag && sub.compareTo(t) < 0) {
                    ways++;
                } else if (!flag && sub.compareTo(t) > 0) {
                    ways++;
                }
            }
        }
        return ways;
    }


}
