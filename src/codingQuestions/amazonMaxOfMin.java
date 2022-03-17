package codingQuestions;

        import java.util.*;

public class amazonMaxOfMin {

    public static void main(String[] args) {
        System.out.println(maxOfAllMin(8, Arrays.asList(10,20,30,40,25,81,98,45),8));
        System.out.println(maxOfAllMin(6, Arrays.asList(8,2,4,3,8,9),3));
    }

    static int maxOfAllMin(int numComputer, List<Integer> hardDiskSpace, int segmentLength){

        Stack<Integer> s = new Stack<>();

        int left[] = new int[numComputer+1];
        int right[]  = new int[numComputer+1];


        for (int i=0; i<numComputer; i++)
        {
            left[i] = -1;
            right[i] = numComputer;
        }

        for (int i=0; i<numComputer; i++)
        {
            while (!s.empty() && hardDiskSpace.get(s.peek()) >= hardDiskSpace.get(i))
                s.pop();

            if (!s.empty())
                left[i] = s.peek();

            s.push(i);
        }


        while (!s.empty())
            s.pop();


        for (int i = numComputer-1 ; i>=0 ; i-- )
        {
            while (!s.empty() && hardDiskSpace.get(s.peek()) >= hardDiskSpace.get(i))
                s.pop();

            if(!s.empty())
                right[i] = s.peek();

            s.push(i);
        }


        int ans[] = new int[numComputer+1];
        for (int i=0; i<=numComputer; i++)
            ans[i] = 0;


        for (int i=0; i<numComputer; i++)
        {
            int len = right[i] - left[i] - 1;
            ans[len] = Math.max(ans[len], hardDiskSpace.get(i));
        }

        for (int i=numComputer-1; i>=1; i--)
            ans[i] = Math.max(ans[i], ans[i+1]);

        return ans[segmentLength];
    }
}
