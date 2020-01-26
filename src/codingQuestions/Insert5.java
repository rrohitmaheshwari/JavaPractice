package codingQuestions;

public class Insert5 {

    public static void main(String[] args) {
        System.out.println(solution(268));
        System.out.println(solution(670));
        System.out.println(solution(0));
        System.out.println(solution(-0));
        System.out.println(solution(-999));
        System.out.println(solution(-439));
    }

    public static int solution(int N) {

        StringBuilder s = new StringBuilder(String.valueOf(Math.abs(N)));

        int sign = 1;  //positive

        if (N < 0) {
            sign = -1;  //negative number
        }

        int i = 0;
        if (sign == 1) {
            //find first digit index for lesser number
            while (i < s.length()) {
                if ((s.charAt(i) - '0' >= 5))
                    i++;
                else
                    break;
            }


        } else {
            //find first digit index for greater number
            while (i < s.length()) {
                if ((s.charAt(i) - '0' <= 5))
                    i++;
                else
                    break;
            }
        }

        //inserting 5
        s.insert(i, '5');

        int val = Integer.parseInt(s.toString());
        return sign * val;

    }



}
