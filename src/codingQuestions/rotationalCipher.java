/*
Meta
Rotational Cipher
One simple way to encrypt a string is to "rotate" every alphanumeric character by a certain amount. Rotating a character means replacing it with another character that is a certain number of steps away in normal alphabetic or numerical order.
For example, if the string "Zebra-493?" is rotated 3 places, the resulting string is "Cheud-726?". Every alphabetic character is replaced with the character 3 letters higher (wrapping around from Z to A), and every numeric character replaced with the character 3 digits higher (wrapping around from 9 to 0). Note that the non-alphanumeric characters remain unchanged.
Given a string and a rotation factor, return an encrypted string.
*/


  String rotationalCipher(String input, int rotationFactor) {
    // Write your code here
    StringBuilder sb= new StringBuilder();
    
    
    for(int i=0;i<input.length();i++)
    {
      char ch = input.charAt(i);
      
      if((ch <= 'z' && ch>='a' ))
      {
         ch = (char)(((int)input.charAt(i) +rotationFactor - 'a') % 26 + 'a');
      }
      else if((ch <= 'Z' && ch>='A'))
      {
          ch = (char)(((int)input.charAt(i) +rotationFactor - 'A') % 26 + 'A');
      }
      else if((ch <= '9' && ch>='0'))
      {
             ch = (char)(((int)input.charAt(i) +rotationFactor - '0') % 10 + '0');
      }
      
      sb.append(ch);
    }
    return sb.toString();
  }
