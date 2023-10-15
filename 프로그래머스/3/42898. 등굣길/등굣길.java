class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n][m];
        
        for (int[] puddle : puddles) {
            map[puddle[1] - 1][puddle[0] - 1] = -1;
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == -1 || i == 0 && j == 0) {
                    map[i][j]++;
                    continue;
                }
                int up = i == 0 ? 0 : map[i - 1][j];
                int left = j == 0 ? 0 : map[i][j - 1];
                map[i][j] = (up + left) % ((int)1e9 + 7);
            }
        }
        
        return map[n - 1][m - 1];
    }
}