
/*
43. Multiply Strings
https://leetcode.com/problems/multiply-strings/submissions/
*/
class Solution {
    public String multiply(String num1, String num2) {
        int carry = 0;
        int mul;
        StringBuilder res;

        String s[]=new String[num2.length()];
        
        int maxLen = 0;
        
        //multiply by 0
        if((num1.length()==1 && num1.charAt(0)=='0')
          ||(num2.length()==1 && num2.charAt(0)=='0'))
        {
            return "0";
        }
        
        
        for(int i=num2.length()-1;i>=0;i--)
        {
            char l = num2.charAt(i);
            
            res=new StringBuilder();
            
            mul = 0;
            carry = 0;
            for(int j=num1.length()-1;j>=0;j--)
            {
                char u=num1.charAt(j);
                
                mul = (l-'0') * (u-'0') + carry;
                carry = mul/10;
                
                res.append((char)(mul%10+'0'));
            }
            
            // If carry has value
             if(carry>0)
            {
                res.append((char)(carry + '0'));
            }
            
            res.reverse();
            
            // shifting place
            for(int j=0;j<num2.length()-i-1;j++)
                res.append('0');
            
            // this can be further optimized to do in place add
            s[i] = res.toString();
            
            maxLen = Math.max(maxLen,s[i].length());
        }
        
        
        return findTotal(s,maxLen);
    }
    public String findTotal(String[] s, int maxLen)
    {
        int carry=0;
        int sum=0;
        StringBuilder res=new StringBuilder();

        for(int i=0;i<maxLen;i++)
        {
            sum=0;
            
            for(int j=0;j<s.length;j++)
            {
                if(s[j].length()-i-1 >= 0 )
                {
                   sum +=  (s[j].charAt(s[j].length()-i-1)-'0');
                }
            }
            sum += carry;
            
            res.append((char)('0'+(sum%10)));
            carry=sum/10;
        }
        if(carry>0)
        {
            res.append((char)('0'+(carry)));
        }
        return res.reverse().toString();
    }
}