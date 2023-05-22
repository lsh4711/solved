import java.util.Arrays;

class Solution {
    public int solution(int n, int[][] computers) {
        int cnt = 0;
        boolean[] visit = new boolean[computers.length];
        
        for (int i = 0; i < computers.length; i++) {
            if (visit[i]) {
                continue;
            }
            dfs(computers, visit, i);
            cnt++;
        }
        
        return cnt;
    }
    
    static void dfs(int[][] computers, boolean[] visit, int go) {
        if (visit[go]) {
            return;
        }
        int[] now = computers[go];
        visit[go] = true;
            
        for (int i = 0; i < now.length; i++) {
            if (now[i] == 1) {
                dfs(computers, visit, i);
            }
        }
        
    }
}