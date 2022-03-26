/*
22. Generate Parentheses
https://leetcode.com/problems/generate-parentheses/
https://leetcode.com/explore/interview/card/google/62/recursion-4/3079/
*/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        
        backtrack(n,0,0,res,new StringBuilder());
        
        return res;
    }
    
    void backtrack(int n,int open,int close,List<String> res,StringBuilder s)
    {
        // break condition
        if(s.length()==n*2)
        {
            res.add(s.toString());
            return;
        }
        
        if(open<n)
        {
            s.append("(");
            backtrack(n,open+1,close,res,s);
            s.deleteCharAt(s.length() - 1);
            
        }
        if(close<open)
        {
            s.append(")");
            backtrack(n,open,close+1,res,s);
            s.deleteCharAt(s.length() - 1);
        }
        
    }
}