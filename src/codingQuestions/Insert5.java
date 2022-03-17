package codingQuestions;

public class Insert5 {

    public static void main(String[] args) {
        System.out.println(solution(268) + " " + solution2(268));
        System.out.println(solution(670)+ " " + solution2(670));
        System.out.println(solution(0)+ " " + solution2(0));
        System.out.println(solution(-0)+ " " + solution2(-0));
        System.out.println(solution(-1)+ " " + solution2(-1));
        System.out.println(solution(-999)+ " " + solution2(-999));
        System.out.println(solution(-439)+ " " + solution2(-439));
        System.out.println(solution(-4539)+ " " + solution2(-4539));
        System.out.println(solution(-8000)+ " " + solution2(-8000));
        System.out.println(solution(8000)+ " " + solution2(8000));

//        for(int i=-8000;i<=8000;i++){
//            if(solution(i)!=solution2(i))
//                System.out.println(i +" "+ solution(i) + " "+solution2(i));
//        }
    }

    public static int solution(int N) {

        StringBuilder s = new StringBuilder(String.valueOf(Math.abs(N)));

        int sign = 1;  //positive

        if (N < 0) {
            sign = -1;  //negative number
        }

        int i = 0;
        if (sign == 1) {
            while (i < s.length()) {
                if ((s.charAt(i) - '0' >= 5))
                    i++;
                else
                    break;
            }


        } else {
            while (i < s.length()) {
                if ((s.charAt(i) - '0' <= 5))
                    i++;
                else
                    break;
            }
        }

        s.insert(i, '5');

        int val = Integer.parseInt(s.toString());
        return sign * val;

    }




    public static int solution2(int N) {

        StringBuilder s = new StringBuilder(String.valueOf(Math.abs(N)));

        int sign = 1;  //positive

        int res = Integer.parseInt(s+"5");

        if (N < 0) {
            sign = -1;  //negative number
        }

        int i = 0;
        if (sign == 1) {
            while (i < s.length()) {
                StringBuilder sb = new StringBuilder(s);
                sb.insert(i, '5');
                res = Math.max(res,Integer.parseInt(sb.toString()));
                i++;
            }

        } else {
            res=-1*res;
            while (i < s.length()) {

                StringBuilder sb = new StringBuilder(s);
                sb.insert(i, '5');
                res = Math.max(res,-1*Integer.parseInt(sb.toString()));
                i++;
            }
        }

   return res;

    }

}
