/*
605. Can Place Flowers
https://leetcode.com/problems/can-place-flowers/
https://leetcode.com/explore/interview/card/linkedin/339/array-and-strings/1972/

O(N)
O(1)
*/

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) 
        {
            // Check if the current plot is empty.
            if (flowerbed[i] == 0) 
            {
                // Check if the left and right plots are empty.
                boolean emptyLeftPlot = (i == 0) || (flowerbed[i - 1] == 0);
                boolean emptyRightPlot = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);
                
                // If both plots are empty, we can plant a flower here.
                if (emptyLeftPlot && emptyRightPlot) 
                {
                    flowerbed[i] = 1;
                    i++; // no need to check next element as we have just placed the flower
                    count++;

                    if (count >= n) 
                    {
                        return true;
                    }
                }
            }
        }

        return count >= n;
    }
}