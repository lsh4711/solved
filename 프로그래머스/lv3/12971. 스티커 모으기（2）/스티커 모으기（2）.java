class Solution {
    static int length;
    static int max = 0;
    
    public int solution(int[] sticker) {
        if (sticker.length < 4) {
            saveMax(sticker);
            return max;
        }
        length = sticker.length;
        
        calculate(sticker, 0);
        calculate(sticker, 1);
        calculate(sticker, 2);
        
        return max;
    }
    
    static void calculate(int[] sticker, int start) {
        int end = start + length - 3;
        int[] idxs = new int[7];
        int[] dp = new int[length];
        
        for (int i = start; i < end; i++) {
            int minus3 = getIdx(i - 3);
            int minus2 = getIdx(i - 2);
            dp[i] = Math.max(dp[minus3], dp[minus2]) + sticker[i];
        }
        for (int i = 2; i < 7; i++) {
            idxs[i] = getIdx(start - i);
        }
        int[] tmp = {
            dp[idxs[6]] + sticker[idxs[3]],
            dp[idxs[5]] + sticker[idxs[3]],
            dp[idxs[5]] + sticker[idxs[2]],
            dp[idxs[4]] + sticker[idxs[2]]
        };
        
        saveMax(tmp);
        
    }
    
    static void saveMax(int[] array) {
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        
    }
    
    static int getIdx(int idx) {
        while (idx < 0) {
            idx += length;
        }
        
        return idx;
    }
}