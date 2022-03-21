/**/
364. Nested List Weight Sum II
https://leetcode.com/problems/nested-list-weight-sum-ii/
https://leetcode.com/explore/interview/card/linkedin/337/recursion-and-backtracking/1992/
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        // breaking the problem
        int maxDepth = dfsFindMaxDepth(nestedList);
        return dfsFindMaxDepth(nestedList,1,maxDepth);
        
    }
    
    int dfsFindMaxDepth(List<NestedInteger> nestedList)
    {
        int depth=1;
        for(NestedInteger n:nestedList)
        {
            if(!n.isInteger())
            {
                    depth = Math.max(
                        depth,
                        1 + dfsFindMaxDepth(n.getList())
                    );
            }
        }
        
        return depth;
    }
    
    int dfsFindMaxDepth(List<NestedInteger> nestedList,int depth,int maxDepth)
    {
        int sum=0;
        for(NestedInteger n:nestedList)
        {
            if(n.isInteger())
            {
                sum+=n.getInteger()*(maxDepth-depth+1);
            }
            else
            {
                sum+=dfsFindMaxDepth(n.getList(),depth+1,maxDepth);
            }
        }
        
        return sum;
    }
    
}