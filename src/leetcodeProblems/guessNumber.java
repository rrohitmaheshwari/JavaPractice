/*
374. Guess Number Higher or Lower
https://leetcode.com/problems/guess-number-higher-or-lower/
O(LogN)
O(N)
*/
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
   
    public int guessNumber(int n) {
        int l=1;
        int r=Integer.MAX_VALUE;
        // int ans =l;
        
        while(l<=r)
        {
           int mid = (r-l)/2 + l;
            int condition = guess(mid);
            if(condition==0)
            {
                return mid;
            }
            else if(condition == 1)
            {
                l = mid+1;
            }
            else // condition -1
            {
                r=mid-1;
            }
        }
        
        return -1; // not expected to run in this case
        
    }
}