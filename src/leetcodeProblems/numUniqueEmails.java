/*
Unique Email Addresses
https://leetcode.com/explore/interview/card/google/67/sql-2/3044/
*/
class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> res = new HashSet<>();
        
        for(String email: emails)
        {
            StringBuilder reducedEmail = new StringBuilder();
            int i=0;
            int len = email.length();
            char ch;
            
            // Extract Alias 
            for(i=0;i<len;i++)
            {
             ch = email.charAt(i);
                
                // break string
                if(ch == '@' || ch == '+')
                {
                    break;
                }
                else if(ch == '.')
                {
                    continue;
                }
                else
                {
                    reducedEmail.append(ch);
                }
            }
            
            // Skip till @
            for(;i<len;i++)
            {
             ch = email.charAt(i);
                if(ch == '@')
                {
                    break;
                }
            }
            
            // Extract Domain 
            for(;i<len;i++)
            {
                 ch = email.charAt(i);
                 reducedEmail.append(ch);
            }
            res.add(reducedEmail.toString());
        }
        return res.size();
        
    }
}
