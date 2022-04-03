/*
2075. Decode the Slanted Ciphertext
https://leetcode.com/problems/decode-the-slanted-ciphertext/
O(N)
O(1)
*/
class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        StringBuilder sb = new StringBuilder();
        
        char[] chars = encodedText.toCharArray();
        
        int cols = chars.length / rows;
        
        int i = 0;
        int j = 0;
        //use this variable to reset j's value.
        int counter = 0;
        
        while (j < cols) {
            while (i < rows && j < cols) {
                int arrayIndex = i * cols + j;
                sb.append(chars[arrayIndex]);
                i++;
                j++;
            }
            counter++;
            
            i = 0;
            j = counter;
        }
        
        return removeSpaces(sb).toString();
    }
    
    private StringBuilder removeSpaces(StringBuilder sb) {
        if (sb.length() < 1) return sb;
        
        while(sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        
        return sb;
    }
}