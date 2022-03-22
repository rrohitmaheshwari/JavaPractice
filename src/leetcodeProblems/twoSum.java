/*
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/submissions/
167. Two Sum II - Input Array Is Sorted
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lo=0,hi=numbers.length-1;
        int sum=0;
        while(lo<hi)
        {
            sum =numbers[lo] + numbers[hi];
            if(sum<target)
            {
                lo++;
            }
            else if(sum>target)
            {
                hi--;
            }
            else
            {
                return new int[]{lo+1,hi+1};
            }
        }
        return new int[]{lo,hi};
    }
}


/* better appoach for non sorted array

*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> m = new HashMap<>();
        
        int temp=0;
        
        for(int i=0;i<nums.length;i++)
        {
            temp=target-nums[i];  //compliment
            if(m.containsKey(temp))
            {
                return(new int[]{m.get(temp),i});
            }
            else
            {
                m.put(nums[i],i);
            }
        }
        
        return new int[0];
    
    }
}