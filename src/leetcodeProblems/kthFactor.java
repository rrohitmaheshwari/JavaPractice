/*
1492. The kth Factor of n
https://leetcode.com/problems/the-kth-factor-of-n/
O(N)
O(1)
*/

class Solution {
    public int kthFactor(int n, int k) {
        for (int x = 1; x < n / 2 + 1; ++x) {
            if (n % x == 0) {
                --k;
                if (k == 0) {
                    return x;    
                }    
            }    
        }
        
        return k == 1 ? n : -1;  //edge case if k==nth factor or if nth exeedes k then -1
    }
}