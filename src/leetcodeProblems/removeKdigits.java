/*
402. Remove K Digits
https://leetcode.com/problems/remove-k-digits/
O(N)
O(N) - Stack
*/

class Solution {
   public String removeKdigits(String num, int k) {
        int size = num.length();
       
        // if size of string is equal to no. of elements can be removed i.e., k
        if(size==k){
            return "0";
        }
       
        Stack<Character> stack = new Stack<>();
       
        int counter=0;
       
        while(counter<size)
        {
            
            while(k>0 && !stack.isEmpty() && stack.peek() > num.charAt(counter))
            {
                stack.pop();
                k--;
            }
            
            stack.push(num.charAt(counter));
            counter++;
        }
       
        // If all elements in increasing order, simply pop out the elements till k=0
        while(k>0)
        {
            stack.pop();
            k--;
        }
        
        StringBuilder builder = new StringBuilder();
       
        while(!stack.isEmpty())
        {
            builder.append(stack.pop());
        }
       
        // elements above are appended in reverse order so need to reverse
        builder.reverse();
        
        // delete the trailing "0" in the start of the String
        while(builder.length()>0 && builder.charAt(0)=='0')
        {
            builder.deleteCharAt(0);
        }
       
        // If final string is becomes empty after removing zeros, return 0 else the final string
        return builder.length()>0 ? builder.toString() : "0";
    }
}