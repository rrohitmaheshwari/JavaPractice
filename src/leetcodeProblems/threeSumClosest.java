/*
16. 3Sum Closest
https://leetcode.com/problems/3sum-closest/
O(nlogN + n^2)
O(N) or O(logN) depending on sort algo

*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        int dif = Integer.MAX_VALUE;
        int len = nums.length;
        Arrays.sort(nums);
        
        for(int i=0;i<len-2;i++)
        {
            int lo = i+1;
            int hi = len-1;
            
            while(lo<hi)
            {
                int sum = nums[i]+nums[lo]+nums[hi];
                
                 if (Math.abs(target - sum) < Math.abs(dif)) 
                 {
                    dif = target - sum;
                 }
                
                if(sum == target)
                {
                    return target;
                }
                else if(sum<target)
                {
                    lo++;
                }
                else
                {
                    hi--;
                }
                
            }
        }
        
        return target - dif;
        
    }
}