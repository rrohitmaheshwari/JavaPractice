package codingQuestions;

public class buySellStock {

    public static void main(String[] args) {

        System.out.println(maxRevenueFromStocks(new int[]{2, 4, 1, 5, 2, 6, 7}, new int[]{0, 1, 0, 0, 1, 0, 0}, 4));

    }

    public static int maxRevenueFromStocks(int[] prices, int[] algo, int k) {

        int sum = 0, fsum;

        for (int i = 0; i < prices.length; i++) {
            if (algo[i] == 1) {
                sum += prices[i];
            } else {
                sum -= prices[i];
            }
        }

        int t = 0;

        for (int j = 0; j < k && j < prices.length; j++) {
            if (algo[j] == 0)
                t = t + 2 * prices[j];
        }

        sum = sum + t;


        fsum = sum;

        int l = 1, r = k;

        while (l <= r && l < prices.length) {

            if (algo[l - 1] == 0) {
                sum = sum - 2 * prices[l-1];
            }

            if (r < prices.length && algo[r] == 0) {
                sum = sum + 2 * prices[r];
            }

            fsum = Math.max(fsum, (sum));

            l++;
            r++;

        }
        return fsum;
    }


}


