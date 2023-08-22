class Solution {
    public int solution(int a, int b, int c) {
        int[][] dices = new int[5][4];
        dices[1] = new int[] {a, b, c, a + b + c};
        
        if (a != b && a != c && b != c) {
            return recursive(dices, 1);
        }
        if (a != b || a != c || b != c) {
            return recursive(dices, 2);
        }
        return recursive(dices, 3);
    }
    
    static int recursive(int[][] dices, int idx) {
        int result = dices[idx][3];

        if (result != 0) {
            return result;
        }

        result = recursive(dices, idx - 1);
        int sum = 0;

        for (int i = 0; i < 3; i++) {
            sum += dices[idx][i] = dices[idx - 1][i] * dices[1][i];
        }

        return dices[idx][3] = result * sum;
    }
}