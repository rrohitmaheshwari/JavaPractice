package codingQuestions;

public class GetProduct {

    public static void main(String[] args) {
        System.out.println(getProduct(1000_000_000));
    }


    static int getProduct(int n)
    {
        int numforSum=n;
        int temp=0;
        int sum=0;
        int product = 1;

        while (n != 0) {
            product = product * (n % 10);
            n = n / 10;
        }

        while(numforSum > 0)
        {
            temp = numforSum % 10;
            sum = sum + temp;
            numforSum = numforSum / 10;
        }

        return Math.abs(product-sum);
    }
}


