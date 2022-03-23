/*
243. Shortest Word Distance
https://leetcode.com/problems/shortest-word-distance/
https://leetcode.com/explore/interview/card/linkedin/339/array-and-strings/1971/
O(NM)
O(1)
*/

class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int i1=-1, i2=-1;
        int shrtDist = wordsDict.length;
        for(int i=0;i< wordsDict.length;i++)
        {
            if(wordsDict[i].equals(word1))
            {
                i1 = i;
            }
            else if(wordsDict[i].equals(word2))
            {
                i2 = i;
            }
            
            if((i1 != -1 && i2 != -1))
            {
               shrtDist= Math.min(shrtDist,Math.abs(i2-i1)); 
            }       
        }
        return shrtDist;
    }
}