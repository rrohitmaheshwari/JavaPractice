/*
1578. Minimum Time to Make Rope Colorful
https://leetcode.com/problems/minimum-time-to-make-rope-colorful/
O(N)
O(1)
*/

class Solution {
    public int minCost(String colors, int[] neededTime) {
        if(neededTime.length == 1)
            return 0;
        
        int cost=0,max,sum;
        char ch;
        for(int i=0;i<colors.length();i++)
        {
            ch=colors.charAt(i);
            max = neededTime[i];
            sum = neededTime[i];
            
            while(i+1<colors.length() && ch == colors.charAt(i+1))
            {
                max= Math.max(max,neededTime[i+1]);
                sum+= neededTime[i+1];
                i++;
            }
            if(sum!=max)
            {
                cost +=sum-max;  //keeping just the max to minimize the sum
            }     
        }
        
        return cost;
        
    }
}