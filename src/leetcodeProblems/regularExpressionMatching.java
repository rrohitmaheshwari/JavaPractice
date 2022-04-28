/*
10. Regular Expression Matching
https://leetcode.com/problems/regular-expression-matching/
O(TP) length of string
O(TP) stack | cache
*/

// with memonization

class Solution {
    Boolean cache[][];
    
    public boolean isMatch(String s, String p) 
    {
        cache = new Boolean[s.length()+1][p.length()+1];
        return helper(s,p,0,0);
    }
    
    boolean helper(String s,String p,int i,int j)
    {
        
       
        if(i==s.length() && j==p.length())
        {
            return true;
        }
        
        // if  pattern is out of bound and i exists then return false
        if(j>=p.length())
        {
            return false;
        }
        
         if(cache[i][j] != null)
        {
            return cache[i][j];
        }
        
        // this is wrong since we can have "a"   with "a*b*"--> still valid
        // if(i>=s.length())
        // {
        //     return false;
        // }
        
        boolean isCharMatch = i<s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        
        if(j+1 < p.length() && p.charAt(j+1) == '*')  // check for *
        {
                    // dont use *        // use *
            boolean res = (helper(s,p,i,j+2) || (isCharMatch && helper(s,p,i+1,j)));   
            cache[i][j] = res;
            return res;
        }
        
        // otherwise normal cases
        if(isCharMatch)
        {
            boolean res = helper(s,p,i+1,j+1);
            cache[i][j] = res;
            return res;
        }
        
        cache[i][j] = false;
        
        return false;
        
        
    }
    
}



//without caching


class Solution {
    
    public boolean isMatch(String s, String p) 
    {
        cache = new HashSet<>();
        return helper(s,p,0,0);
    }
    
    boolean helper(String s,String p,int i,int j)
    {
        if(i==s.length() && j==p.length())
        {
            return true;
        }
        
        // if  pattern is out of bound and i exists then return false
        if(j>=p.length())
        {
            return false;
        }
        
        // this is wrong since we can have "a"   with "a*b*"--> still valid
        // if(i>=s.length())
        // {
        //     return false;
        // }
        
        boolean isCharMatch = i<s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        
        if(j+1 < p.length() && p.charAt(j+1) == '*')  // check for *
        {
                    // dont use *        // use *
           return (helper(s,p,i,j+2) || (isCharMatch && helper(s,p,i+1,j)));   
        }
        
        // otherwise normal cases
        if(isCharMatch)
        {
            return helper(s,p,i+1,j+1); 
        }
        
        return false;
        
        
    }
    
}