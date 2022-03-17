package codingQuestions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class AmazonBox {

    public static void main(String[] args) {
//        System.out.println(3,);
    }

    public static long maximumUnits(int nums, ArrayList<Integer> boxes, int unitSize, ArrayList<Integer> unitPerBox, long truckSize) {

        int[][] boxToUnit = new int[boxes.size()][2];
        int i=0;
        for(int box : boxes) {
            boxToUnit[i][0] = box;
            boxToUnit[i][1] = unitPerBox.get(i);
            i++;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->b[1] - a[1]);
        queue.addAll(Arrays.asList(boxToUnit));
        long unitCount = 0;
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            long boxCount = Math.min(truckSize, top[0]);
            unitCount += boxCount * top[1];
            truckSize -= boxCount;
            if(truckSize == 0)
                break;
        }
        return unitCount;
    }
}
