/*
394. Decode String
https://leetcode.com/problems/decode-string/
https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/3073/
O(maxK*n) maxK is the maximum value of k
O(n)
*/

class Solution {
    int index=0;
    
    // decodeString returns the decoded string XX[YY]=>  XX * YY
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        // get number and string 
        while(index<s.length() && s.charAt(index)!=']')
        {
            // handle pure string from recursion
            if(!Character.isDigit(s.charAt(index)))
            {
                result.append(s.charAt(index++));
            }
            else
            {
                // get number
                int number=0;
                while(index<s.length()  && Character.isDigit(s.charAt(index)))
                {
                  number = number *10  + s.charAt(index++) - '0';
                }
                //ignore '['
                index++;

                // recursive call to get internal strings
                String decodedString = decodeString(s);

                //ignore ']'
                index++;
                // build k
                while(number-->0)
                {
                    result.append(decodedString);
                }
            }
        }
           return result.toString();
        
    }
}