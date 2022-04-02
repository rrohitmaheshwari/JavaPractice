/*
408. Valid Word Abbreviation
https://leetcode.com/problems/valid-word-abbreviation/
O(N)
O(H) - used string builder....can be optimized using int
*/

class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        
        int index = 0;char ch;
        for(int i=0;i<abbr.length();i++)
        {
            ch = abbr.charAt(i);
            
            if(ch <= 'z' && ch >= 'a')
            {
                if (index>=word.length() || ch != word.charAt(index))
                {
                   return false; 
                }
                index++;
            }
            else // extract number
            {
                StringBuilder sb = new StringBuilder();
                
                if(abbr.charAt(i) == '0') //leading 0
                    return false;
                
                 while(i<abbr.length() && abbr.charAt(i) <= '9'  
                       && abbr.charAt(i)>= '0')
                 {
                     sb.append(abbr.charAt(i)); 
                     i++;
                 }
            
                int  skip = Integer.parseInt(sb.toString());
                    System.out.println(skip);
                i--; // as i will again be incremented in next loop
                index+=skip; 
            }
        }
        if(index == word.length())
           return true;
        
        return false;
        
    }
}