/*
539. Minimum Time Difference
https://leetcode.com/problems/minimum-time-difference/
O(N)
O(24*60) -> O(1)  constant memory
*/

class Solution {
   public int findMinDifference(List<String> timePoints) {
        int len = 24*60;
        boolean[] mem = new boolean[len];
       
        int first = Integer.MAX_VALUE;
        int last = Integer.MIN_VALUE;
       
        for(String s: timePoints)
        {
            int index = hour2min(s);
            first = Math.min(index,first);
            last = Math.max(index,last);
            
            if(mem[index] == true)  // repetative means 0 diff
                return 0;
            
            mem[index] = true;
        }
       
       // we have atleast two points so no need to check for more corner cases for first and last validity
       
        int ans = Integer.MAX_VALUE;
       
        int curr = first;
       
        for(int i = first+1;i <= last;i++)
        {
               if(mem[i] == true) 
               {
                   ans = Math.min((i-curr),ans);
                   curr=i;
               }
        }
        return Math.min(ans,(first + len -last));
    }
    
    private int hour2min (String s){
        int hour = (s.charAt(0) - '0')*10 + (s.charAt(1) - '0');
        int minute = (s.charAt(3) - '0') * 10 + (s.charAt(4) - '0');
        return hour*60 + minute;
    }
}