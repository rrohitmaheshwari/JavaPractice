package codingQuestions;

public class codilityGuidewire {

    public static void main(String[] args) {


//        System.out.println(solution(2, "1A 2F 1C"));
        System.out.println(solution(11, "10A"));
    }

    public static int solution(int N, String S) {

        int res = 0;

        String[] filled = S.split(" ");

        int seats[][] = new int[N][10];


        if (filled[0] != "") {
            for (String s : filled) {
                if (s.length() == 2) {
                    seats[s.charAt(0) - '1'][s.charAt(1) - 'A']++;
                } else {
                    seats[((s.charAt(0) - '0') * 10) + (s.charAt(1) - '1')][s.charAt(2) - 'A']++;
                }
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < 10; j++)
//                System.out.print(seats[i][j] + " ");
//            System.out.println();
//        }



        boolean flag;
        for (int i = 0; i < N; i++) {
            flag = true;
            if (seats[i][1] == 0 && seats[i][2] == 0 && seats[i][3] == 0 && seats[i][4] == 0) {
                res++;
                flag = false;
            }

            if (seats[i][5] == 0 && seats[i][6] == 0 && seats[i][7] == 0 && seats[i][8] == 0) {
                res++;
                flag = false;
            }

            if (flag && seats[i][3] == 0 && seats[i][4] == 0 && seats[i][5] == 0 && seats[i][5] == 0) {
                res++;
            }

        }


        return res;

    }
}
