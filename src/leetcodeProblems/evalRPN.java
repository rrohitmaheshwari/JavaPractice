/*
150. Evaluate Reverse Polish Notation
https://leetcode.com/problems/evaluate-reverse-polish-notation/
https://leetcode.com/explore/interview/card/linkedin/336/heap-queue-stack/1959/
O(N)
O(N)
*/
class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> st = new Stack<>();
        int result;
        for(String s:tokens)
        {
            result=0;
            if(isNumeric(s))
            {
                st.push(Integer.parseInt(s));
            }
            else
            {
                if(s.equals("+"))
                {
                   result =   st.pop() + st.pop();
                }
                else if(s.equals("-"))
                {
                   result =  -st.pop() + st.pop();
                }
                 else if(s.equals("/"))
                {
                     result = st.pop();
                     result = st.pop() / result;
                }
                 else if(s.equals("*"))
                {
                   result = st.pop() * st.pop();
                }
                 st.push(result);
            }
        }
        return st.pop();
        
    }
    
    public static boolean isNumeric(String str) { 
      try {  
        Integer.parseInt(str);  
        return true;
      } catch(Exception e){  
        return false;  
      }  
}
}