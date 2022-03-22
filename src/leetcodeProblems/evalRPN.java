/*
150. Evaluate Reverse Polish Notation
https://leetcode.com/problems/evaluate-reverse-polish-notation/
https://leetcode.com/explore/interview/card/linkedin/336/heap-queue-stack/1959/
O(N)
O(N)
*/

class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<String> st = new Stack<>();
        int result;
        for(String s:tokens)
        {
            result=0;
            if(isNumeric(s))
            {
                st.push(s);
            }
            else
            {
                if(s.equals("+"))
                {
                   result =   Integer.parseInt(st.pop())+Integer.parseInt(st.pop());
                }
                else if(s.equals("-"))
                {
                   result =  - Integer.parseInt(st.pop())+ Integer.parseInt(st.pop());
                }
                 else if(s.equals("/"))
                {
                     result = Integer.parseInt(st.pop());
                   result = Integer.parseInt(st.pop())/result;
                }
                 else if(s.equals("*"))
                {
                   result =   Integer.parseInt(st.pop())*Integer.parseInt(st.pop());
                }
                 st.push(result+"");
            }
        }
        return Integer.parseInt(st.pop());
        
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