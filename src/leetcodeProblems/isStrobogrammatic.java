/*
246. Strobogrammatic Number
https://leetcode.com/problems/strobogrammatic-number/submissions/
O(N)
O(1)
*/

class Solution {

    public boolean isStrobogrammatic(String num) {
        
        // Initialise a map with the five-digit rotation rules
        Map<Character, Character> rotatedDigits = new HashMap<> (
            Map.of('0','0', '1','1', '6','9', '8','8', '9','6'));
        
        StringBuilder rotatedStringBuilder = new StringBuilder();
        
        // Remember that we want to loop backwards through the string
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if (!rotatedDigits.containsKey(c)) {
                return false; // This must be an invalid digit.
            }
            rotatedStringBuilder.append(rotatedDigits.get(c));
        }
        
        String rotatedString = rotatedStringBuilder.toString();
        return num.equals(rotatedString);
    }
}