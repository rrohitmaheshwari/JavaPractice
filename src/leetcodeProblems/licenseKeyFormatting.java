/*
License Key Formatting
https://leetcode.com/explore/interview/card/google/67/sql-2/472/
*/

class Solution {
    public String licenseKeyFormatting(String s, int k) {
    int count=0;
        s=s.toUpperCase();
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--){
            
            if(s.charAt(i)!='-'){
              if(count%k==0 && sb.length()>0){
                sb.append("-");    
              }  
              sb.append(s.charAt(i));  
              count++; 
            }
        }
        return new String(sb.reverse());
    }
}
