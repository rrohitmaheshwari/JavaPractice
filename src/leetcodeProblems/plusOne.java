/*
Plus One
https://leetcode.com/explore/interview/card/google/59/array-and-strings/339/
*/
class Solution {
    public int[] plusOne(int[] digits) {
        
        int len=digits.length;
        
        for(int j=len-1;j>=0;j--)
        {
            digits[j]++;
            digits[j]=digits[j]%10;

            if(digits[j] != 0)
            {
                break;
            }
        }
        if(digits[0] == 0)
        {
            digits = new int[len + 1];
            digits[0] = 1;
        }

        return digits;
    }
}
