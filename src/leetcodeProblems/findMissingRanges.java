/*
163. Missing Ranges
https://leetcode.com/problems/missing-ranges/
https://leetcode.com/explore/interview/card/google/59/array-and-strings/3055/
*/

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> sol = new ArrayList<>();
   
        for (int i = 0; i < nums.length; i++) 
        {
             if (lower <= nums[i] - 1) {
                sol.add(formatRange(lower , nums[i] - 1));
             }
            
            //update lower with value + 1 
            lower = nums[i]+1;
        }
        
         if (lower <= upper) {
                sol.add(formatRange(lower, upper));
             }
        
        return sol;
        
    }
    
    // formats range in the requested format
    private String formatRange(int lower, int upper) {
        // Eg [2,2] =>   "2"
        if (lower == upper) 
        {  
            return String.valueOf(lower);
        }
        // Eg [4,8] =>  "4->8"
        return lower + "->" + upper;
    }
}