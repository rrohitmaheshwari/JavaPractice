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

//------------OPTIMIZED WAY


/*
Time complexity: 
O(n)O(n) for creating the <index, value> pair for non-zero values; 
O(L1+L2) for dot product

Space complexity: 
O(L) for creating the <index, value> pairs for non-zero values. 
O(1)O(1) for calculating the dot product.
*/

class SparseVector {

    List<int[]> sparseList;

    SparseVector(int[] nums) {
        sparseList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) 
        {
            if (nums[i] != 0) 
            {
                sparseList.add(new int[]{i, nums[i]});
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0, p = 0, q = 0;
        while (p < sparseList.size() && q < vec.sparseList.size()) 
        {
            if (sparseList.get(p)[0] == vec.sparseList.get(q)[0]) 
            {
                result += sparseList.get(p)[1] * vec.sparseList.get(q)[1];
                p++;
                q++;
            }
            else if (sparseList.get(p)[0] > vec.sparseList.get(q)[0]) 
            {
                q++;
            }
            else 
            {
                p++;
            }
        }
        return result;
    }
}