package codingQuestions;

public class NetflixFlipCoins {

    public static void main(String[] args) {
//        System.out.println(solution(new int[]{1, 0, 1, 0, 1, 1}));
//        System.out.println(solution(new int[]{1, 1, 0, 1, 1}));
//        System.out.println(solution(new int[]{0, 1, 0}));
        System.out.println(solution(new int[]{0,1,1,0}));

    }

    public static int solution(int[] A) {
        return Math.min(helper(A, 0),
                helper(A, 1));
    }

    public static int helper(int[] A, int coinStatus) {
        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != coinStatus)
                cnt++;
            coinStatus = (coinStatus == 0) ? 1 : 0;
        }
        return cnt;
    }
}
