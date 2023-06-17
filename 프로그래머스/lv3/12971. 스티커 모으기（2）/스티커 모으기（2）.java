class Solution {
    static int length;
    static int max = 0;
    
    public int solution(int[] sticker) {
        length = sticker.length;
        
        if (length == 1) {
            return sticker[0];
        } else if (length == 2) {
            return Math.max(sticker[0], sticker[1]);
        }
        for (int i = -1; i <= 1; i++) {
            calculate(sticker, i);
        }
        
        return max;
    }
    
    static void calculate(int[] sticker, int start) {
        int end = start + length;
        int[] dp = new int[length];

        for (int i = start; i <= end; i++) {
            int idx = getIdx(i);
            int minus3 = getIdx(idx - 3);
            int minus2 = getIdx(idx - 2);
            dp[idx] = Math.max(dp[minus3], dp[minus2]) + sticker[idx];
        }
        start = getIdx(start);
        
        dp[start] -= sticker[start];
        if (dp[start] > max) {
            max =  dp[start];
        }

    }
    
    static int getIdx(int idx) {
        if (idx >= length) {
            return idx - length;
        } else if (idx < 0) {
            return idx + length;
        }

        return idx;
    }
}
