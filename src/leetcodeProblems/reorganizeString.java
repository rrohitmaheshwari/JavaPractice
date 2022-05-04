/*
767. Reorganize String
https://leetcode.com/problems/reorganize-string/

O(N)
O(1) - 26 is constant
*/

/*
No Sort O(N):

count letter appearance and store in hash[i]
find the letter with largest occurence.
put the letter into even index numbe (0, 2, 4 ...) char array
put the rest into the array but again using +2 format from the pointer left.
and then reset it to 1 if pointer exceded the end

*/
class Solution {
   public String reorganizeString(String S) 
   {
       // freq conunter like hashmap <char,interger>
        int[] hash = new int[26];
        
       for (int i = 0; i < S.length(); i++) 
       {
            hash[S.charAt(i) - 'a']++;
        } 
       
        int max = 0, letter = 0;
       
       // find max letter and its count
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > max) {
                max = hash[i];
                letter = i;
            }
        }
       
       // if max exeedes half of len then sol not possible
        if (max > (S.length() + 1) / 2) {
            return ""; 
        }
       
        // res char array
        char[] res = new char[S.length()];
        int idx = 0;
       
       // put max in 0,2,4 ...
        while (hash[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            hash[letter]--;
        }
       
       // put remaining in ... 8,10  then resent counter to 1 for: 1, 3 , 5 ...
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) 
            {
                if (idx >= res.length) 
                {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                hash[i]--;
            }
        }
        return String.valueOf(res);
    }
}