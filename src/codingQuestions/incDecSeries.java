package codingQuestions;

public class incDecSeries {

    public static void main(String[] args) {

        System.out.println(getSequenceSum(5, 9, 6));
    }

    static long getSequenceSum(int i, int j, int k) {
        long res = j;

        while (j != i && j != k) {

            j = j - 1;
            res = res + (long) 2 * j;

        }

        if ((j - i) > (j - k)) {
            while (j != i) {
                j--;
                res = res + j;
            }

        } else if ((j - i) < (j - k)) {
            while (j != k) {
                j--;
                res = res + j;
            }

        }

        return res;
    }

    static long sumHelper(int f, int l) {
        return ((long) (f - l) / 2) * (f + l);
    }
}
