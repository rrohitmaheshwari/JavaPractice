/*
71. Simplify Path
https://leetcode.com/problems/simplify-path/
O(N)
O(N) - array and stack
*/

class Solution {
    public String simplifyPath(String path) {
        // remove repetative /
        
        StringBuilder sModified = new StringBuilder();
        
        for(int i=0;i<path.length();i++)
        {
            char ch = path.charAt(i);
            
            if(ch == '/' 
               && i>0 
               && path.charAt(i-1) == '/')
               {
                   continue;
               }
               else
               {
                   sModified.append(ch);
               }
        }
               
        String[] components = sModified.toString().split("/");
        Stack<String> stack = new Stack<String>();
        
            for (String directory : components) 
            {
                
                if (directory.equals(".") || directory.isEmpty()) 
                {
                  continue;
                }
                else if(directory.equals(".."))
                {
                    // pop unless root
                    if (!stack.isEmpty()) 
                    {
                        stack.pop();
                    }
                }
                else //
                {
                    stack.add(directory);
                }
            }
        
        sModified = new StringBuilder();
         for (String dir : stack) 
         {
            sModified.append("/");
            sModified.append(dir);
         }

         return sModified.length() > 0 ? sModified.toString() : "/" ;
    }
}