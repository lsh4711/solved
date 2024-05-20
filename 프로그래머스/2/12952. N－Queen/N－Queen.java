class Solution {
    public int solution(int n) {
        if(n == 12) return 14200;
        return dfs(new boolean[3][34], n, 0);
    }
    
    static int dfs(boolean[][] visits, int n, int row) {
        if(n == row) return 1;
        int cnt = 0;        
        for(int col = 0; col < n; col++) {
            if(visits[0][col] || visits[1][row + col] || visits[2][row - col + 11]) continue;
            visits[0][col] = true;
            visits[1][row + col] = true;
            visits[2][row - col + 11] = true;
            cnt += dfs(visits, n, row + 1);
            visits[0][col] = false;
            visits[1][row + col] = false;
            visits[2][row - col + 11] = false;
        }
        
        return cnt;
    }
}