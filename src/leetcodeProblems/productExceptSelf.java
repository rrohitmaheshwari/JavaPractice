/*
238. Product of Array Except Self
https://leetcode.com/problems/product-of-array-except-self/
O(N)
O(N)....O(1) solution with resusing same array
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int  N= nums.length;
        int left[] = new int[N];
        int right[] = new int[N];
        int res[] = new int[N];
        
        left[0]=nums[0];
        for(int i=1;i<N;i++)
        {
            if(nums[i] == 0)
                break;
            left[i] = left[i-1] * nums[i];
        }
        
          right[N-1]=nums[N-1];
        for(int i=N-2;i>=0;i--)
        {
            if(nums[i] == 0)
                break;
            right[i] = right[i+1] * nums[i];
        }
        
        res[0] = right[1];
        res[N-1] = left[N-2];
        for(int i=1;i<N-1;i++)
        {
            res[i] = left[i-1] * right[i+1];
        }

        return res;
        
    }
}


class Solution {
    public int[] productExceptSelf(int[] nums) {

        // The length of the input array 
        int length = nums.length;

        // Final answer array to be returned
        int[] answer = new int[length];

        // answer[i] contains the product of all the elements to the left
        // Note: for the element at index '0', there are no elements to the left,
        // so the answer[0] would be 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {

            // answer[i - 1] already contains the product of elements to the left of 'i - 1'
            // Simply multiplying it with nums[i - 1] would give the product of all 
            // elements to the left of index 'i'
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R contains the product of all the elements to the right
        // Note: for the element at index 'length - 1', there are no elements to the right,
        // so the R would be 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {

            // For the index 'i', R would contain the 
            // product of all elements to the right. We update R accordingly
            answer[i] = answer[i] * R;
            R *= nums[i];
        }

        return answer;
    }
}