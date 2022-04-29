/*
442. Find All Duplicates in an Array
https://leetcode.com/problems/find-all-duplicates-in-an-array/

O(N)
O(1)

This is for non negtive numbers in range[1->n]
*/

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for (int num : nums) {
            if (nums[Math.abs(num) - 1] < 0) { // seen before
                ans.add(Math.abs(num));
            }
            else
            {
                nums[Math.abs(num) - 1] *= -1;
            }
        }

        return ans;
    }
}