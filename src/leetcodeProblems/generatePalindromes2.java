/*
267. Palindrome Permutation II
https://leetcode.com/problems/palindrome-permutation-ii/
O(n!)
O(n) - > dfs tree visiting every node
*/

class Solution {public List<String> generatePalindromes(String s) 
{
    int[] map = new int[256];
    for(int i=0;i<s.length();i++)
    {
        map[s.charAt(i)]++;
    }

    int j=0,count=0;

    for(int i=0;i<256;i++)
    {
        if(count== 0 && map[i] %2 == 1)
        {
            j= i;
            count++;
        }
        else if(map[i] % 2==1)
        {
            return new ArrayList<String>();
        }
    }

    StringBuilder cur = new StringBuilder();

    if(j != 0)
    {
        map[j]--;
    }

    List<String> res = new ArrayList<String>();
    DFS(res,cur,map,s.length(),j);
    return res;
}
public void DFS(List<String> res,StringBuilder cur,int[] map,int len,int j){
    if(cur.length()== len/2)
    {
        if(j!=0)
        {
            res.add(cur.toString() + (char)j+ cur.reverse().toString());
        }
        else
        {
            res.add(cur.toString() + cur.reverse().toString());
        }
         cur.reverse();
    }
    else 
    {
        for(int i=0;i<map.length;i++){
            if(map[i] <= 0) 
                continue;
            map[i] = map[i] - 2;
            
            cur = cur.append((char)i);
            
            DFS(res,cur,map,len,j);
            
            cur.setLength(cur.length() - 1); // remove last added
            map[i] = map[i]+2;
        }
    }
}
}