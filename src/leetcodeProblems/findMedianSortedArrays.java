/*
4. Median of Two Sorted Arrays
https://leetcode.com/problems/median-of-two-sorted-arrays/
O(Log (Min(m,n)))
O(1)
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a = nums1;
        int[] b = nums2;

        //A must be shorter then B
        if (a.length > b.length) {
            a = nums2;
            b = nums1;
        }

        int total = a.length + b.length;
        int half = total / 2;
        int l = 0, r = a.length-1;
        double midAns = 0.0;

        while (true) {

            int mid = (Math.floorDiv(l+r, 2)); // pointer for A
            int j = half - mid - 2;  // pointer for B

            int Aleft =  mid >= 0 ? a[mid] : Integer.MIN_VALUE;
            int Aright = mid+1 < a.length ? a[mid+1] : Integer.MAX_VALUE;
            
            int Bleft = j >= 0 ? b[j] : Integer.MIN_VALUE;
            int Bright = j+1 < b.length ? b[j+1] : Integer.MAX_VALUE;

            if (Bleft <= Aright && Aleft <= Bright ) {

                // even
                if (total % 2 == 0) {
                    return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright) ) / 2.0;
                } 
                else  //odd
                {
                   return Math.min(Aright, Bright);
                }

            } 
            else if (Aleft > Bright) 
            {
                r = mid - 1;
            } 
            else 
            {
                l = mid + 1;
            }

        }

    }
}