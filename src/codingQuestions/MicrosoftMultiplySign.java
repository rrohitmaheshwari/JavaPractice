package codingQuestions;

public class MicrosoftMultiplySign {
    public static void main(String[] args) {
        MicrosoftMultiplySign a = new MicrosoftMultiplySign();
        System.out.println(a.solution(new int[]{1, -2, -3, 5}));
        System.out.println(a.solution(new int[]{1, 2, 3, -5}));
        System.out.println(a.solution(new int[]{1, 2, 0, -5}));
        System.out.println(a.solution(new int[]{-1}));
        System.out.println(a.solution(new int[]{1}));

        System.out.println(a.solution(new int[]{-1, -1}));
        System.out.println(a.solution(new int[]{1, -1}));

        System.out.println(a.solution(new int[]{-1, 1}));
        System.out.println(a.solution(new int[]{1, 1}));
    }

    public int solution(int[] A) {
        boolean isPositive = true;

        for (int i : A) {
            if (i < 0) {
                isPositive = !isPositive;
            } else if (i > 0) {
                continue;
            } else {
                return 0;
            }
        }
        return isPositive ? 1 : -1;
    }
}
