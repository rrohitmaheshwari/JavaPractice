/*
252. Meeting Rooms
https://leetcode.com/problems/meeting-rooms/solution/
O(NLogN)
O(N)
*/

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });
        for(int i=0;i<intervals.length-1;i++)
        {
            if(intervals[i][0] == intervals[i+1][0] 
               || intervals[i][1] > intervals[i+1][0] )
                return false;
        }
        
        return true;
        
    }
}