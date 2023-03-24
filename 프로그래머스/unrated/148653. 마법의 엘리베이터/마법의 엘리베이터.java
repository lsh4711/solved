import java.util.Arrays;

class Solution {
    public int solution(int storey) {
        int[] dp = new int[storey + 1];
        
        Arrays.fill(dp, (int)1e9);
        dp[storey] = 0;
        for(int i = storey; i > 0; i--) {
            if(dp[i] == (int)1e9) continue;
            int r = i % 10;
            int q = i / 10;
            dp[q] = Math.min(dp[q], dp[i] + r);
            dp[q + 1] = Math.min(dp[q + 1], dp[i] - r + 10);
        }

        return dp[0];
    }
}