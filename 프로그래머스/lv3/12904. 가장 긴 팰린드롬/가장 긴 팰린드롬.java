class Solution {
    static int max;

    public int solution(String s) {
        int[][] dp = new int[s.length()][s.length()];
        
        for (int i = s.length() - 1; i >= 0; i--) {
            if (max >= i + 1) {
                break;
            }
            for (int j = 0; j < s.length() - i; j++) {
                int left = j;
                int right = j + i;
                recursive(dp, s, left, right);
            }
        }
        
        return max;
    }
    
    static int recursive(int[][] dp, String s, int left, int right) {
        if (dp[left][right] != 0) {
            return dp[left][right];
        }
        if (left == right || left - right == 1) {
            max = left - right + 1;
            return dp[left][right] = 1;
        }
        if (s.charAt(left) == s.charAt(right)) {
            int result  = recursive(dp, s, left + 1, right - 1);
            if (result == 1) {
                max = right - left + 1;
                return dp[left][right] = 1;
            }
        }
        return dp[left][right] = -1;
    }
}