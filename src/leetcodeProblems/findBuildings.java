/*
1762. Buildings With an Ocean View
https://leetcode.com/problems/buildings-with-an-ocean-view/
O(N)
O(1)
*/

class Solution {
    public int[] findBuildings(int[] heights) {
        
        int counter = 1;
        
        int max = heights[heights.length-1];
        heights[heights.length-1] =-1;
        
        for(int i=heights.length-2;i>=0;i--)
        {
            if(heights[i]>max)
            {
                counter++;
              
                max =heights[i]; 
                heights[i]=-1;
            }
        }
        int[] _view = new int[counter];
        
        int j=0;
        
        for(int x=0;x<heights.length;x++)
        {
            if(heights[x]==-1)
            {
                _view[j]=x;
                j++;
            }
        }
       
        
        return _view;
    }
}