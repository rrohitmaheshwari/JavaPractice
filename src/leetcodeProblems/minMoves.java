/*
2139. Minimum Moves to Reach Target Score
https://leetcode.com/problems/minimum-moves-to-reach-target-score/
O(N)
O(1)

Idea is to go backwords
*/

class Solution {
    public int minMoves(int target, int maxDoubles) 
    {
        
        int ans = 0;
        while(target != 1)
        {
            if(target%2==1)
            {
                target--;
                ans++;
            }
            else
            {
                if(maxDoubles>0)
                {
                    maxDoubles--; 
                    target = target/2;
                    ans++;
                }
                else
                {
                    ans=ans+target-1;
                    break;
                }      
            }
            
        }
        
        return ans;
        
    }
}