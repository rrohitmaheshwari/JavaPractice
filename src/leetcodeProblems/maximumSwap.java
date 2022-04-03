/*
670. Maximum Swap
https://leetcode.com/problems/maximum-swap/
O(N)
O(10) - const length bucket
*/
class Solution {
    public int maximumSwap(int num) {
        char digit[] = Integer.toString(num).toCharArray();
        
        int buckets[]=new int[10];
        
       for (int i = 0; i < digit.length; i++) 
        {
           buckets[digit[i] - '0'] = i;
        }
        
        for (int i = 0; i < digit.length; i++)
        {
            for(int j=9;j>digit[i]-'0';j--)
            {
                if(buckets[j] > i)
                {
                    //swap
                    char tmp = digit[i];
                    digit[i] = digit[buckets[j]];
                    digit[buckets[j]] = tmp;
                    return Integer.valueOf(new String(digit));
                }
            }
        }
        
        return num; //no swap
    }
}