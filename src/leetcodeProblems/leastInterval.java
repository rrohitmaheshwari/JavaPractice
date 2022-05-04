/*
621. Task Scheduler
O(N) - sorting of 26 is constant
O(1)
*/

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] fc = new int[26];
        
        for(char c:tasks)
        {
            fc[c-'A']++;
        }
        
        Arrays.sort(fc);
        
        int max = fc[25];
        int idleTime = (max-1)*n;
        
         for(int i=0;i<26;i++)
         {
              System.out.print(fc[i]+" ");
         }
       
        for(int i=24;i>=0 && idleTime>0;i--)
        {
              idleTime -= Math.min(max-1, fc[i]); 
        }
        

        // idle_time cannot be negative(last idle slots are not actully idle)
        // Ex, 3A 3B 1C. ->. ABC | AB_ | AB
        // the above code only alocates mid spaces not the last space so idle Time can go negative
        idleTime = Math.max(0,idleTime);
        
        return idleTime+tasks.length;
        
    }
}