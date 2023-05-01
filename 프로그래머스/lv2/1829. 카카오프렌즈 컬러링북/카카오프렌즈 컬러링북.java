class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int cnt = 0;
        int max = 0;
        int[][] copy = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) copy[i][j] = picture[i][j];
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(copy[i][j] == 0) continue;
                max = Math.max(max, dfs(copy, new int[] {i, j}, m, n));
                cnt++;
            }
        }

        return new int[] {cnt, max};
    }

    static int dfs(int[][] picture, int[] xy, int m, int n) {
        int tmp = picture[xy[0]][xy[1]];
        if(tmp == 0) return 0;
        int cnt = 1;
        int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        picture[xy[0]][xy[1]] = 0;
        for(int i = 0; i < 4; i++) {
            int[] move = moves[i];
            int[] next = {xy[0] + move[0], xy[1] + move[1]};
            if(next[0] < 0 || next[1] < 0 || next[0] >= m || next[1] >= n) continue;
            if(picture[next[0]][next[1]] != tmp) continue;
            cnt += dfs(picture, next, m, n);
        }

        return cnt;
    }
}