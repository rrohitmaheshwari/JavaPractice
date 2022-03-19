/*
20. Valid Parentheses
https://leetcode.com/problems/valid-parentheses/solution/
https://leetcode.com/explore/interview/card/google/59/array-and-strings/467/
*/

class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stk = new Stack();
        int index=0;
        char ch;
        
        while(index<s.length())
        {
            ch = s.charAt(index); 
            if(ch  == '('  )
            {
                stk.push(')');
            }
            else if(ch  == '{'  )
            {
                stk.push('}');
            }
            else if(ch  == '['  )
            {
                stk.push(']');
            }
            else if(ch  == ')' || ch  == '}' ||ch  == ']' )
            {
                if(!stk.empty() && stk.peek() == ch )
                {
                    stk.pop();
                }
                else
                {
                    return false;
                }
            }
            index++;
        }

        
        return stk.empty();
    }

}