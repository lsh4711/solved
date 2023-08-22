class Solution {
    public int solution(int a, int b, int c) {
        int result = 1;
        int[][] dices = new int[7][3];
        
        dices[a][0] = a;
        dices[b][0] = b;
        dices[c][0] = c;
        for (int i = 1; i < 3; i++) {
            dices[a][i] = dices[a][i - 1] * a;
            dices[b][i] = dices[b][i - 1] * b;
            dices[c][i] = dices[c][i - 1] * c;
        }
        
        if (a == b && a == c && b == c) {
            for (int i = 0; i < 3; i++) {
                int sum = 0;
                sum += dices[a][i];
                sum += dices[b][i];
                sum += dices[c][i];
                result *= sum;
            }
            return result;
        }
        if (a != b && a != c && b != c) {
            result = dices[a][0];
            result += dices[b][0];
            result += dices[c][0];
            return result;
        }
        for (int i = 0; i < 2; i++) {
            int sum = 0;
            sum += dices[a][i];
            sum += dices[b][i];
            sum += dices[c][i];
            result *= sum;
        }
        
        return result;
    }
}