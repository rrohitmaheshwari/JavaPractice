/*
636. Exclusive Time of Functions
https://leetcode.com/problems/exclusive-time-of-functions/
https://leetcode.com/explore/interview/card/linkedin/336/heap-queue-stack/1961/
*/

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        //store current running process
        Stack<Integer> st = new Stack<>();
        int prevLogTime=-1; // initial value doenst matter as this will be overriden in first run
        
        // store result array
        int res[]=new int[n];
        
        for(String log:logs)
        {
            // splitting could also be optimzed by using custom splitter
            String s[] = log.split(":");
            
            int timeStamp = Integer.parseInt(s[2]); 
            
            if(s[1].equals("start")) //action start
            {
                if(!st.isEmpty())
                {
                    // add execution to previous run
                    res[st.peek()] += timeStamp - prevLogTime;
                }
                // add new start task to stack
                st.add(Integer.parseInt(s[0]));
                
                // update prevTime with current timestamp
                prevLogTime = timeStamp;
            }
            else // action end
            {
                //pop from stack as this process must have ended
                // & update its time execution
                res[st.pop()] += timeStamp - prevLogTime  +1;
                
                // prevLog time will show current timestamp+1 to store process end time   
                prevLogTime = timeStamp+1; 

            }
        }
        
        return res;
    }
}