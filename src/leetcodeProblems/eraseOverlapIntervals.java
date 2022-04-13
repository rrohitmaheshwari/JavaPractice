/*
435. Non-overlapping Intervals
https://leetcode.com/problems/non-overlapping-intervals/submissions/
O(NLogN) - Sorting
O(1) - No extra space is used. (Considering sorting didnt take extra space)

*/

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        if(intervals.length == 1)
            return 0;
        
        Arrays.sort(intervals,(a,b)->{
            if(a[0] == b[0])
                return a[1]-b[1];
            else
                return a[0]-b[0];
        });


        int lpnt = 0;
        LinkedList<int []> l = new LinkedList<>();
        
        l.add(intervals[0]);
        
        for(int i =1;i<intervals.length;i++)
        {
            if(intervals[lpnt][0] == intervals[i][0])
            {
               continue;  
            }
               
            if(intervals[lpnt][1] > intervals[i][0])  //overlap
            {
                if(intervals[lpnt][1] > intervals[i][1])
                {
                   intervals[lpnt]=intervals[i];
                }    
            }
            else
            {
                lpnt++;
                intervals[lpnt]=intervals[i];    
            }
        }
        
        return intervals.length - lpnt-1;
        
    }
}


/*
O(N) space
*/
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        if(intervals.length == 1)
            return 0;
        
        Arrays.sort(intervals,(a,b)->{
            if(a[0] == b[0])
                return a[1]-b[1];
            else
                return a[0]-b[0];
        });
        
//         for(int i[]:intervals)
//         {
//                 System.out.format("[%d %d],", i[0],i[1]);
//         }
        

        LinkedList<int []> l = new LinkedList<>();
          
        l.add(intervals[0]);
        
        for(int i =1;i<intervals.length;i++)
        {
            if(l.getLast()[0] == intervals[i][0])
                continue;
            if(l.getLast()[1] > intervals[i][0])
            {
                if(l.getLast()[1] > intervals[i][1])
                {
                    l.removeLast();
                    l.add(intervals[i]);
                }    
            }
            else
            {
                 l.add(intervals[i]);
            }
        }
        
        return intervals.length - l.size();
        
    }
}