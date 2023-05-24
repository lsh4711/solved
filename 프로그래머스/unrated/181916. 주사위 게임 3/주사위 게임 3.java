import java.util.Arrays;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int max = 0;
        int[] abcd = {a, b, c, d};
        int[] rolls = new int[7];
        int[][] cnt = new int[5][4];
        
        for (int i : abcd) {
            rolls[i]++;
        }
        for (int i = 6; i >= 1; i--) {
            int roll = rolls[i];
            if (max < roll) max = roll;
            for (int j = 3; j >= 0; j--) {
                if (cnt[roll][j] == 0) {
                    cnt[roll][j] = i;
                    break;
                }
            }
        }
        
        if (max == 4) {
            return cnt[4][3] * 1111;
        }
        if (max == 3) {
            return (int)Math.pow(cnt[3][3] * 10 + cnt[1][3], 2);
        }
        if (max == 2) {
            if (cnt[2][2] == 0) {
                return cnt[1][2] * cnt[1][3];
            }
            return (cnt[2][2] + cnt[2][3]) * Math.abs(cnt[2][2] - cnt[2][3]);
        }
        return cnt[1][0];
    }
}