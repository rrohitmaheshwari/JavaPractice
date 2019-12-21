package codingQuestions;

public class GuidewireCodility {
    public static void main(String[] args) {

        int arr[] = new int[]{0, 1010, 213, 553, 28651231, Integer.MAX_VALUE, 100_000_000, 100_000_001, 1999999991};


        for (int i : arr) {
            System.out.println(i + " - " + solution(i));
        }

    }

    public static int solution(int N) {


        if (N == 0) {
            return 0;
        }
        short charCount[] = new short[10];
        int result = 0;


        while (N > 0) {
            charCount[N % 10]++;
            N = N / 10;
        }


        StringBuilder tempString = new StringBuilder();

        for (int i = 0; i <= 9; i++) {
            while (charCount[i] > 0) {
                tempString.insert(0, i + "");
                charCount[i]--;
            }
        }

        try {
            result = Integer.parseInt(tempString.toString());
        } catch (Exception e) {
            return -1;

        }

        if (result > 100_000_000) {
            return -1;
        }


        return result;
    }
}
