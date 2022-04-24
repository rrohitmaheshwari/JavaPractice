/*
552. Student Attendance Record II
https://leetcode.com/problems/student-attendance-record-ii/
O(N)
O(N)

Can be done by DP
*/

class Solution {
    private final int MOD = 1000000007;
    
    public int checkRecord(int n) 
    {                      
        //.              len,acount,consecutiveL,cache
        return (int)(count(n, 0, 0, new Long[n + 1][2][3]) % MOD);
    }
    
    private long count(int n, int absentCount, int consecutiveLate, Long[][][] memo)
    {
        if(absentCount == 2 || consecutiveLate == 3) return 0;
        if(n == 0) return 1;
        
        if(memo[n][absentCount][consecutiveLate] != null) 
            return memo[n][absentCount][consecutiveLate];
        
        long present = count(n - 1, absentCount, 0, memo) % MOD; // present
        long absent = count(n - 1, absentCount + 1, 0, memo) % MOD; // absent
        long late = count(n - 1, absentCount, consecutiveLate + 1, memo) % MOD; // late
        
        memo[n][absentCount][consecutiveLate] = (present + absent + late) % MOD;
        return memo[n][absentCount][consecutiveLate];
    }
}
