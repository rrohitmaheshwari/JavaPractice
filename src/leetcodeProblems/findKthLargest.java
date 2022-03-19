/*
215. Kth Largest Element in an Array
https://leetcode.com/problems/kth-largest-element-in-an-array/
https://leetcode.com/explore/interview/card/google/59/array-and-strings/361/
time - O(N log(k))
space -O(k)

*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // for a min priority queue(smallest element at top) of size k
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((i1,i2)->(i1.compareTo(i2)));
        
        for(int n:nums)
        {
            pq.add(n);
            if(pq.size()>k)
            {
                pq.poll();
            }
        }
        
        return pq.peek();
        
    }
}