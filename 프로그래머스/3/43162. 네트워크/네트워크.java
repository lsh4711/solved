class Solution {
    public int solution(int n, int[][] computers) {
        int result = countNetwork(computers);
        return result;
    }
    
    private int countNetwork(int[][] computers) {
        int cnt = 0;
        boolean[] visited = new boolean[computers.length];
        
        for (int i = 0; i < computers.length; i++) {
            if (visited[i]) {
                continue;
            }
            dfs(computers, visited, i);
            cnt++;
        }
        
        return cnt;
    }
    
    private void dfs(int[][] computers, boolean[] visited, int computer) {
        if (visited[computer]) {
            return;
        }
        
        visited[computer] = true;
        
        for (int dest = 0; dest < computers.length; dest++) {
            if (computers[computer][dest] == 0) {
                continue;
            }
            dfs(computers, visited, dest);
        }
        
    }
}