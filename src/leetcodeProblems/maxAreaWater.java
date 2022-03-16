/*
  Container With Most Water

https://leetcode.com/explore/interview/card/google/59/array-and-strings/3048/

*/
class Solution {
    public int maxArea(int[] height) {
        int start=0;
        int end = height.length -1;
        
        int waterArea = 0;
        while(start<end)
        {
            waterArea = Math.max(waterArea, (end-start)*Math.min(height[end],height[start]));
            
            if(height[end]<height[start])
            {
                end--;
            }
            else
            {
                start++;
            }
        }
        return waterArea;
        
    }
}
