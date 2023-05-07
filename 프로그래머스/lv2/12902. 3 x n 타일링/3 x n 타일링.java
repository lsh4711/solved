class Solution {
    public int solution(int n) {
        int[] dp = new int[n / 2 + 1];
        int[] strange = new int[n / 2 + 1];
        dp[1] = 3;
        
        return dfs(dp, strange, n / 2, (int)1e9 + 7);
    }
    
    static int dfs(int[] dp, int[] strange, int n, int r) {
        if(dp[n] != 0) return dp[n];
        dp[n] = (int)((dfs(dp, strange, n - 1, r) * 3L + strange[n - 1] * 2 + 2) % r);
        strange[n] = (strange[n - 1] + dp[n - 1]) % r;
        
        return dp[n];
    }
}  