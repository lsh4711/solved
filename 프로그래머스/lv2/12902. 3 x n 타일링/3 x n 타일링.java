class Solution {
    public int solution(int n) {
        int special = 0 ;
        int r = (int)1e9 + 7;
        int[] dp = new int[n + 1];
        dp[2] = 3;
        
        for(int i = 4; i <= n; i += 2) {
            dp[i] = (int)((dp[i - 2] * 3L + special * 2 + 2) % r);
            special = (special + dp[i - 2]) % r;
        }
        
        return dp[n];
    }
}