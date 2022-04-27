/*
418. Sentence Screen Fitting
https://leetcode.com/problems/sentence-screen-fitting/
O(N)
O(N)
*/

class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = "";
        int ret = 0;
        for(int i=0; i<sentence.length; i++)
            s+=sentence[i]+" ";
        int char_fit = 0;
        for(int i=0; i<rows; i++)
        {
            char_fit = char_fit + cols; //keep adding cols, as these are available slots to be filled in ro
			// and by doing this, you specifically calculate the index of word that will be at the end of the
			// column
            if(s.charAt(char_fit%s.length()) == ' ')
            {
               char_fit++;
            }
            else
            {
                while(char_fit>0 && s.charAt((char_fit-1)%s.length())!=' ') // reduce char_fit till we find ' '
                    char_fit--;
            }
        }
        ret = char_fit/s.length();
        return ret;
    }
}