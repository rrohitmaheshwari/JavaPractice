/*

  Expressive Words

https://leetcode.com/explore/interview/card/google/59/array-and-strings/3056/

TC:O(S|s|*M) where  S|s| is size of s and M is words length
Space:O(S|s|+S|M|*k) where k is number of words
*/

class Solution {
    public int expressiveWords(String s, String[] words) {
     
        // custom function to shorten the strings
        List<Str> reducedS =  wordReducer(s);
        int count = 0;
        int resCount = 0;
     
        // System.out.println(reducedS);
        // System.out.println("-------");
        
             for(int i=0;i<words.length;i++)
             {
                 List<Str> temp =  wordReducer(words[i]);
                 // System.out.println(temp);
                 
                 count = 0;
                   for(int j=0;j<reducedS.size() && reducedS.size() == temp.size();j++)
                   {
                       // check ch(also checks for count 1)
                       if((reducedS.get(j).ch != temp.get(j).ch))
                          break; 
                       
                       // reducedS if 2 then temp needs to be 2 -count 2 check
                        if(reducedS.get(j).val == 2 &&  temp.get(j).val!=2)
                           break;
                       
                       // reducedS cant be smaller than temp
                       if(reducedS.get(j).val < temp.get(j).val)
                           break;

                         count++;
                   }
                 if(count == reducedS.size())
                 {
                     resCount++;
                 }
             }
        return resCount;
    }
    
    public List<Str> wordReducer(String s)
    {
        List<Str> res = new ArrayList<>();
        int count = 0;
        for(int i=0;i<s.length();i++)
        {
            count = 1;
            while(i+1<s.length() && s.charAt(i) == s.charAt(i+1))
            {
                count++;
                i++;    
            }
            
               res.add(new Str(s.charAt(i),count)); 
        }
        
        return res;
    }
    
    // custom class
    class Str
    {
        int val;
        char ch;
        
        Str(char ch,int val)
        {
        this.val = val;
        this.ch = ch;
        }
        
         @Override
        public String toString() 
        {
        return this.ch + " - " + this.val ;
        } 
    }
}