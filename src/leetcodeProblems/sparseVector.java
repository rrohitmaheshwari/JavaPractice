/*
1570. Dot Product of Two Sparse Vectors
https://leetcode.com/problems/dot-product-of-two-sparse-vectors/solution/
O(N)
O(1)

Question can be asked if you can optimize the docProduct at expence of initializing? We can use hashmap to store non zero?
*/
class SparseVector {
    
 int[] nums;
    SparseVector(int[] nums) {
        this.nums = nums;
    }
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {        
        int n = nums.length;
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += nums[i] * vec.nums[i];
        }        
        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);