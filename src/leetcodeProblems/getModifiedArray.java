/*
370. Range Addition
https://leetcode.com/problems/range-addition/
O(N + k)
O(1)

*/

class Solution {
   public int[] getModifiedArray(int length, int[][] updates) {

    int[] res = new int[length];
       
     for(int[] update : updates) 
     {
        int start = update[0];
        int end = update[1];
        int value = update[2];
        
        res[start] = res[start] + value;
        
        if(end < length - 1)  // to make sure we dont go outside array
        {
           res[end + 1] = res[end + 1] -  value; 
        }      
    }
    
    int sum = 0;
    for(int i = 0; i < length; i++) 
    {
        sum = sum + res[i]; // running sum
        res[i] = sum;
    }
    
    return res;
}
}