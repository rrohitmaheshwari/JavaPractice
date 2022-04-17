/*
1404. Number of Steps to Reduce a Number in Binary Representation to One
https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/
O(N)
O(1)
*/

class Solution {
    public int numSteps(String s) 
    {
        int ans=0;
        int carry=0;
        for(int i=s.length()-1;i>=1;i--)  // we need to reach till number becomes 1
        {
            if(s.charAt(i)-'0' + carry == 1)
            {
                // odd case
                carry = 1;
                ans=ans+2;   
            }
            else
            {
                //even case
                ans++;
            }
        }
        return ans+carry;  // if carry is persent then number 1 -> 10. -step-> 1   
    }
}