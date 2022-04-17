/*
151. Reverse Words in a String
https://leetcode.com/problems/reverse-words-in-a-string/
O(N)
O(N)
*/

class Solution {
    public String reverseWords(String s) 
    {  
        StringBuilder sb = trimSpaces(s);

        // reverse the whole string
        reverse(sb, 0, sb.length() - 1);

        // reverse each word
        reverseEachWord(sb);
        
        return sb.toString();
       
    }

    public void reverseEachWord(StringBuilder sb)
    {
        int n = sb.length();
        int s = 0, e = 0;
        
        while(s<n)
        {
            while(e<n && sb.charAt(e)!=' ')
            {
                e++; 
            }
            
            reverse(sb,s,e-1); // e - 1 ensure we didnt put space
            
            s = e+1;
            e++;
        }
        
    }
    
    public void reverse(StringBuilder sb,int l,int r)
    {
        while(l<r)
        {
            // swap left right
            char tmp = sb.charAt(l);
            sb.setCharAt(l, sb.charAt(r));
            sb.setCharAt(r, tmp);
            
            l++;
            r--;
        }
    }
    
   
    public StringBuilder trimSpaces(String s) 
    {
        StringBuilder sb = new StringBuilder("");
        int left = 0, right = s.length()-1;

        //remove spaces from both side
        while (left <= right && s.charAt(left) == ' ') 
        {
            ++left;
        }


        while (left <= right && s.charAt(right) == ' ') 
        {
            --right;
        }

        if(left == right)
        {
            return sb;  
        }
        while (left <= right) 
        {
          char c = s.charAt(left);

          if (c != ' ') 
          {
              sb.append(c);
          }
          else if (sb.charAt(sb.length() - 1) != ' ')   // check sb last added char
          {
              sb.append(c);
          }

          ++left;
        }
        
        return sb;
    }
}