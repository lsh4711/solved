class Solution {
    public int solution(String s) {
        int max = 1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            char left = s.charAt(i);
            char right = s.charAt(i + 1);
            if (left == right) {
                dp[i][i + 1] = true;
                max = 2;
            }
        }
        for (int i = 2; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                char left = s.charAt(j);
                char right = s.charAt(j + i);
                if (left != right || !dp[j + 1][j + i - 1]) {
                    continue;
                }
                dp[j][j + i] = true;
                max = i + 1;
            }
        }
        
        return max;
    }
}