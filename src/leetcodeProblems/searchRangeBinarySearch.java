/*
34. Find First and Last Position of Element in Sorted Array
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/3081/
O(log n)
O(1)
*/

class Solution {
    public int[] searchRange(int[] nums, int target) 
    {
        int a = binarysearchfirst(nums,target);
        
         if (a == -1) 
             return new int[]{-1, -1};
        
        int b = binarysearchlast(nums,target);
           return new int[]{a, b};
    }
    int binarysearchfirst(int[] nums, int target)
    {
         int left = 0;
        int right = nums.length - 1;
        int leftMostIndex = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;    
            } else if(nums[mid] == target){
                leftMostIndex = mid;
                right = mid - 1;     
            }
        }
        return leftMostIndex;
    }
    
    int binarysearchlast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightMostIndex = -1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if(nums[mid] == target) {
                rightMostIndex = mid;
                left = mid + 1;
            }
        }
        return rightMostIndex;
    }
    
}