package codingQuestions;

public class tomSawyerFence {

    public static void main(String[] args) {
        System.out.println(getAnswer(5, new int[]{1, 0, 1, 0, 1}));
        System.out.println(getAnswer(12, new int[]{1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1}));

    }

    public static long getAnswer(int n, int[] arr) {
        long ans = 0;

        int i = 0;
        boolean flag = false;
        int temp = 0;

        while(i < arr.length)
        {
            if(arr[i] == 1 && !flag)
            {
                ans = 1;
                flag = true;
            }

            else if(arr[i] == 0 && flag)
            {
                temp += 1;
            }

            else if(arr[i] == 1 && flag)
            {
                if(ans == -1)
                {
                    ans = 1;
                }
                temp += 1;
                ans *= temp;
                temp = 0;
            }

            i++;
        }

        return ans;
    }
}
