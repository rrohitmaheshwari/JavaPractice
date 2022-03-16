/*
3Sum

https://leetcode.com/explore/interview/card/google/59/array-and-strings/3049/
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // nlog(n)
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length && nums[i]<=0;i++)
        {
            if(i==0 || nums[i-1] != nums[i])
            {
                twoSum(i+1,nums,res);
            }
        }
        return res;
        
    }
    public void twoSum(int i,int[] nums,List<List<Integer>> res)
    {
        int lo = i, hi = nums.length -1;
        while(lo<hi)
        {
            int sum = nums[i-1] + nums[lo] + nums[hi];
            if(sum<0)
            {
                lo++;
            }
            else if(sum>0)
            {
                hi--;
            }
            else
            {
                res.add(Arrays.asList(nums[i-1],nums[lo],nums[hi]));
                    lo++;
                     hi--;
                    // skip repetitive
                    while(lo<hi && nums[lo]==nums[lo-1])
                    {
                        lo++;
                    }
                    
            }
        }
        
    }
}
