/*
373. Find K Pairs with Smallest Sums
https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
O(n + klog(n)) where n = nums2.length
O(k)

intution: consider it as merge of k sorted list


		num2\num1	   1        7         11
             2        1,2      7,2       11,2
		     4        1,4      7,4       11,4
		     6        1,6      7,6       11,6
*/

class Solution {
    
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int cols = nums1.length, rows = nums2.length;

        List<List<Integer>> ans = new ArrayList<>();

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for(int row = 0; row < rows; row++) 
            q.add(new int[]{nums2[row] + nums1[0], row, 0}); // {value, row, col}

        while(!q.isEmpty()) {
            int[] val = q.poll();
            int r = val[1];
            int c = val[2];
            
            ans.add(new ArrayList<>(Arrays.asList(nums1[c], nums2[r])));
            
            k--;
            
            if(k == 0) 
            {
                return ans;
            }

            c++;
            
            if(c == cols) 
            {
               continue; 
            } 
            
            q.add(new int[]{nums1[c] + nums2[r] , r , c});
        }

        return ans;
    }
}