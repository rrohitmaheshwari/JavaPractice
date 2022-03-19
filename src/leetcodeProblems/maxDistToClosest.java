/*
849. Maximize Distance to Closest Person
https://leetcode.com/explore/interview/card/google/59/array-and-strings/3058/
https://leetcode.com/problems/maximize-distance-to-closest-person/
*/

   /*
        [1,0,0,0,1,0,1]
    left[0,1,2,3,0,1,0]
   right[0,3,2,1,0,1,0]
     min[0,1,2,1,0,1,0]
max(min)=2
        */

class Solution {
    public int maxDistToClosest(int[] seats) 
    {
        
        // or we can use two pointer to save space
        int left[]=new int[seats.length];
        int max_min = 1;
        int distance = Integer.MAX_VALUE;

        for(int i=0;i<seats.length;i++)
        {
            if(seats[i] == 1)
            {
                distance = 0;
            }

            left[i] = distance;

            if(distance!=Integer.MAX_VALUE)
            {
                distance++;
            }
        }
        
        distance = Integer.MAX_VALUE;
        
        // now move from right and evalute min
        for(int i=seats.length-1;i>=0;i--)
        {
            if(seats[i] == 1)
            {
                distance = 0;
            }
                  
            left[i]=Math.min(distance,left[i]);  
            
            max_min=Math.max(max_min,left[i]);
            
            if(distance!=Integer.MAX_VALUE)
            {
                distance++;
            }
      
        }
        
        return max_min;
    }
}