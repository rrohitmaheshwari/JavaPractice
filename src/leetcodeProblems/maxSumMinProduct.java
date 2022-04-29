/*
1856. Maximum Subarray Min-Product
https://leetcode.com/problems/maximum-subarray-min-product/
O(N)
O(N)

Leetcode throws error for this code but seems correct to me :(
*/

class Solution {
    public int maxSumMinProduct(int[] nums) 
    {
        //stack
        Stack<int[]> st = new Stack<>();  // store index,min_so_far_value
        
        //prefix sum
        int sum[] = new int[nums.length+1];
        sum[0] = 0;
         // System.out.print(sum[0] +" ");
        for(int i=1;i<=nums.length;i++)
        {
            sum[i] = sum[i-1] + nums[i-1];
             // System.out.print(sum[i] +" ");
        }
        
        // System.out.println();
        
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++)
        {
            int newStart = i;
    
            
            while(!st.isEmpty() && st.peek()[1]>nums[i])
            {
                int el[]=st.pop();
                // System.out.println(nums[i]+"  -> "+el[0]+" "+el[1]);
                
                int start = el[0];
                int val = el[1];
                // calc min
                int total = sum[i]-sum[start];
                max = Math.max(max,total*val);  
                newStart=start;
            }
            
            st.push(new int[]{newStart,nums[i]}); 
        }
        
          while(!st.isEmpty())
            {
              int el[]=st.pop();
              // System.out.println(el[0]+" "+el[1]);
              int start = el[0];
              int val = el[1];
                // calc min
              int total = sum[nums.length]-sum[start];
              // System.out.println("start:"+start+" Total:"+total);
              max = Math.max(max,total*val);  
            }
        return max %1000000007;
        
        
    }
}