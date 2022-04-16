/*
https://leetcode.com/problems/maximum-value-after-insertion/
1881. Maximum Value after Insertion
O(N)
O(1)
*/

class Solution {
    public String maxValue(String n, int x) {
        int i = 0;
        boolean isPositive = true;
        
        if(n.charAt(0) == '-')
        {
            i=1;
            isPositive=false;
        }

        while(i < n.length())
        {
            if (!isPositive && n.charAt(i) > '0'+x)
                break;
            else if (isPositive && n.charAt(i) < '0'+x)
                break;
            i++;
        }
        
        return  n.substring(0, i) + x + n.substring(i);
    }
}