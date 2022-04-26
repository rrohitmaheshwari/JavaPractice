/*
410. Split Array Largest Sum
https://leetcode.com/problems/split-array-largest-sum/

Time complexity: O((N ^2) * M)

Each state is defined by the values currIndex and subarrayCount. As such, there are N \cdot MN⋅M possible states, and we must visit almost every state in order to solve the original problem. Each state (subproblem) requires O(N)O(N) time because we have a for loop from currIndex to N - subarrayCount. 

Space complexity:O(N⋅M)

The memoization results are stored in the table memo with size N \cdot MN⋅M. Also, stack space in the recursion is equal to the maximum number of active functions. The maximum number of active functions can be equal to MM as we only make a recursive call when splitting the array and we do not make a recursive call when there is only 11 subarray remaining. Hence, the space complexity is equal to O(N⋅M).

Copied from Leetcode

There is one more optimized solution that uses binary search(get max and min sum possible then identify the window)


Refer: https://www.youtube.com/watch?v=YUF3_eBdzsk
*/

class Solution {
    // Defined it as per the maximum size of array and split count
    // But can be defined with the input size as well
    Integer[][] memo = new Integer[1001][51];
    
    private int getMinimumLargestSplitSum(int[] prefixSum, int currIndex, int subarrayCount) {
        int n = prefixSum.length - 1;
        
        // We have already calculated the answer so no need to go into recursion
        if (memo[currIndex][subarrayCount] != null) {
            return memo[currIndex][subarrayCount];
        }
        
        // Base Case: If there is only one subarray left, then all of the remaining numbers
        // must go in the current subarray. So return the sum of the remaining numbers.
        if (subarrayCount == 1) {
            return memo[currIndex][subarrayCount] = prefixSum[n] - prefixSum[currIndex];
        }
        
        // Otherwise, use the recurrence relation to determine the minimum largest subarray
        // sum between currIndex and the end of the array with subarrayCount subarrays remaining.
        int minimumLargestSplitSum = Integer.MAX_VALUE;
        for (int i = currIndex; i <= n - subarrayCount; i++) {
            // Store the sum of the first subarray.
            int firstSplitSum = prefixSum[i + 1] - prefixSum[currIndex];
            
            // Find the maximum subarray sum for the current first split.
            int largestSplitSum = Math.max(firstSplitSum, 
                                      getMinimumLargestSplitSum(prefixSum, i + 1, subarrayCount - 1));
            
            // Find the minimum among all possible combinations.
            minimumLargestSplitSum = Math.min(minimumLargestSplitSum, largestSplitSum);
             
            if (firstSplitSum >= minimumLargestSplitSum) {
                break;
            }
        }
        
        return memo[currIndex][subarrayCount] = minimumLargestSplitSum;
    }
    
    public int splitArray(int[] nums, int m) {
        // Store the prefix sum of nums array.
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        return getMinimumLargestSplitSum(prefixSum, 0, m);
    }
}