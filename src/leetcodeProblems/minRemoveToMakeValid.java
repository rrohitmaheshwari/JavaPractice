/*
1249. Minimum Remove to Make Valid Parentheses
https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
O(N)
O(1) - sb will store data then deletes it but its used as result so not counting that
*/


class Solution {
    public String minRemoveToMakeValid(String s) {
        
        // if invalid parenthesis found we should remove it
        
        StringBuilder sb=new StringBuilder();
        
        int paranCount=0;
        for(char ch:s.toCharArray())
        {
            if(ch == '(')
            {
                paranCount++;  // consider always valid
                sb.append(ch);
            }
            else if(ch == ')')
            {
              
                if(paranCount<=0) //  invalid
                {
                    // do not count close
                    // do not take the char
                }
                else   // valid close will be considered
                {
                    paranCount--;
                    sb.append(ch);
                }
            }
            else
            {
                sb.append(ch);
            }
        }
        
        //remaining "open" should have close but if not(if paranCount>0) then  we will remove open brackets from the end of string
        

        for(int i=sb.length()-1;i>=0&& paranCount>0;i--)
        {
            if(sb.charAt(i) == '(')
            {
                paranCount--;
                sb.deleteCharAt(i);
            }  
        }

        return sb.toString();
        
    }
}