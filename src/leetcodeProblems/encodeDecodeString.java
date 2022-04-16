/*
271. Encode and Decode Strings
https://leetcode.com/problems/encode-and-decode-strings/solution/
O(N) -- inner while will not run more than 3 times as string length limit is 200
O(1)
*/

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        
       StringBuilder sb = new StringBuilder();
        for (String x : strs) {
            sb.append(x.length());
            sb.append("/");
            sb.append(x);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) 
    {
       List<String> r = new ArrayList<>();
        
        int i = 0, v = 0;
        
        while (i < s.length()) 
        {
            while (Character.isDigit(s.charAt(i))) 
            {
                v = v * 10 + s.charAt(i) - '0';
                i++;
            }
            
            r.add(s.substring(i+1,i+1+v));
            i = i + 1 + v;
            v = 0;
        }
        return r;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));