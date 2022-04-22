/*
239. Sliding Window Maximum
https://leetcode.com/problems/sliding-window-maximum/
O(N) -> Linear
O(k) -> Deque
*/

class Solution {
    
    public int[] maxSlidingWindow(int[] nums, int k)
    {
         if (nums == null) 
         {
             return nums;
         }
    
        int n = nums.length;
        
        // Base case
        if (n == 0 || k == 0) 
        {
            return new int[0];
        }

        int[] result = new int[n - k + 1];

        // Deque will store "indices"
        Deque<Integer> deque = new ArrayDeque<>();

        int windowStart = 0;
        
        for (int windowEnd = 0; windowEnd < n; windowEnd++) 
        {
            // pop out smaller values from deque
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[windowEnd]){
                deque.removeLast();
            }

            deque.add(windowEnd);
            // remove left value from window
            
            if (windowStart > deque.getFirst()) {
                deque.removeFirst();
            }

            if (windowEnd + 1 >= k)  // this so that window can be formed first
            {
                result[windowStart] = nums[deque.getFirst()];
                windowStart++;
            }
        }
        return result;
        
    }
}