class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int cnt = 0;
        int max = 0;
        boolean[][] visits = new boolean[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(visits[i][j] || picture[i][j] == 0) continue;
                max = Math.max(max, dfs(picture, visits, new int[] {i, j}, m, n));
                cnt++;
            }
        }
        
        return new int[] {cnt, max};
    }
    
    static int dfs(int[][] picture, boolean[][] visits, int[] xy, int m, int n) {
        if(visits[xy[0]][xy[1]]) return 0;
        visits[xy[0]][xy[1]] = true;
        int cnt = 1;
        int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for(int i = 0; i < 4; i++) {
            int[] move = moves[i];
            int[] next = {xy[0] + move[0], xy[1] + move[1]};
            if(next[0] < 0 || next[1] < 0 || next[0] >= m || next[1] >= n || visits[next[0]][next[1]]) continue;
            if(picture[xy[0]][xy[1]] != picture[next[0]][next[1]] || picture[next[0]][next[1]] == 0) continue;
            cnt += dfs(picture, visits, next, m, n);
        }
        
        return cnt;
    }
}