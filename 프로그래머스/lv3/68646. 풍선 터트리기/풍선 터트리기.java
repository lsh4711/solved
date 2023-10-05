class Solution {
    public int solution(int[] a) {
        int leftIdx = 0;
        int rightIdx = a.length - 1;
        int[][] dp = new int[a.length][2];
        
        dp[leftIdx][0] = a[leftIdx++];
        dp[rightIdx][1] = a[rightIdx--];
        for (int i = 0; i < a.length - 1; i++) {
            dp[leftIdx][0] = Math.min(dp[leftIdx - 1][0], a[leftIdx++]);
            dp[rightIdx][1] = Math.min(dp[rightIdx + 1][1], a[rightIdx--]);
        }
        
        int cnt = Math.min(a.length, 2);
        
        for (int i = 1; i < a.length - 1; i++) {
            int now = a[i];
            int left = dp[i - 1][0];
            int right = dp[i + 1][1];
            if (left > now || now < right) {
                cnt++;
            }
        }
        
        return cnt;
    }
} 