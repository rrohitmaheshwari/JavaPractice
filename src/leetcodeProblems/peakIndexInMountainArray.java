/*
852. Peak Index in a Mountain Array
https://leetcode.com/problems/peak-index-in-a-mountain-array/
https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/3084/
O(LogN)
O(1)
*/

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        // perform modified binary search
        int l = 0;
        int r = arr.length-1;
        int mid=0;
        while(l<r)
        {
            mid = (l+r)/2;
             if (arr[mid] < arr[mid + 1])
                l = mid + 1;
            else
                r = mid;
        }
            
        return l;
    }
}