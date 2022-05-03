/*
1189. Maximum Number of Balloons
https://leetcode.com/problems/maximum-number-of-balloons/
O(N)
O(1)

Follow up: Find genenic way using freqcounter array
*/

class Solution {
    public int maxNumberOfBalloons(String text) {
        
        int b=0,a=0,l=0,o=0,n=0;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        
        for(char ch:text.toCharArray())
        {
            switch(ch)
            {
                case 'b':
                    b++;
                    break;
                    
                case 'a':
                    a++;
                    break;
                                    
                case 'l':
                    l++;
                    break;
                                    
                case 'o':
                    o++;
                    break;
                                    
                case 'n':
                    n++;
                    break;
            }
        }
        
        if(b == 0 || a ==0 || l==0 || o==0 || n==0)
            return 0;
        
        min1 = Math.min(min1,b);
        min1 = Math.min(min1,a);
        min1 = Math.min(min1,n);
        
        min2 = Math.min(min2,l);
        min2 = Math.min(min2,o);
        min2 = min2/2;
        
        
        return Math.min(min1,min2);
        
    }
}