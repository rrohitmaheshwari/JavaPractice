/*
11. Container With Most Water
https://leetcode.com/problems/container-with-most-water/
O(N)
O(1)
*/

class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l=0,r=n-1;
        
        int maxArea = Math.min(height[l],height[r])*(r-l);
        
        while(l<r)
        {
            maxArea = Math.max(maxArea,Math.min(height[l],height[r])*(r-l));
       
            if(height[l]<height[r])
            {
                l++;
            }
            else
            {
                r--;
            }
        }
        
        return maxArea;
        
    }
}