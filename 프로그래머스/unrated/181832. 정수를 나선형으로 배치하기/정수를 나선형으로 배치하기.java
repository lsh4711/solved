class Solution {
    public int[][] solution(int n) {
        int idx = 0;
        int num = 1;
        int[] now = {0, -1};
        int[][] result = new int[n][n];
        int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        while(num <= n * n) {
            int row = now[0] + move[idx][0];
            int col = now[1] + move[idx][1];
            if(row < 0 || col < 0 || row >= n || col >= n || result[row][col] != 0) {
                idx = (idx + 1) % 4;
                continue;
            }
            result[row][col] = num++;
            now = new int[] {row, col};
        }
        
        return result;
    }
}