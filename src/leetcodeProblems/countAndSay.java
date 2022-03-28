/*
38. Count and Say
https://leetcode.com/problems/count-and-say/
*/

class Solution {
    public String countAndSay(int n) {
        
     	StringBuilder curr=new StringBuilder("1");
        
        while(n-->1)
        {
            curr=helper(curr);
        }
	    
        return curr.toString();
    }
    
    StringBuilder helper(StringBuilder curr)
    {  	
        StringBuilder res=new StringBuilder();       
        int count=1;
        char say=curr.charAt(0); //first say

        for (int j=1,len=curr.length();j<len;j++)
        {
            if (curr.charAt(j)!=say)
            {
                res.append(count).append(say); //add to result
                count=1;  //reset count
                say=curr.charAt(j); // update say to next value
            }
            else 
            {
                count++;  // just update count for repetative
            }
        }
        res.append(count).append(say);	//add last say and value
        return res;
    }
}