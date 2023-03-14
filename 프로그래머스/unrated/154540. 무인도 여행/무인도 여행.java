import java.util.*;

class Solution {
    public List<Integer> solution(String[] maps) {
        ArrayList<Integer> answer = new ArrayList<>();
        boolean[][] visit = new boolean[maps.length][maps[0].length()];
        
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[0].length(); j++) {
                if(visit[i][j] || maps[i].charAt(j) == 'X') continue;
                int food = bfs(maps, visit, i, j);
                if(food == 0) answer.add(-1);
                else answer.add(food);
            }
        }
        answer.sort(null);
        
        if(answer.size() == 0) return Arrays.asList(-1);
        return answer;
    }
    
    static int bfs(String[] maps, boolean[][] visit, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        int cnt = 0;
        
        queue.add(new int[] {i, j});
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int row = poll[0];
            int col = poll[1];
            if(row<0 || col<0 || row>=visit.length || col>=visit[0].length || visit[row][col] || maps[row].charAt(col) == 'X') continue;
            visit[row][col] = true;
            cnt += maps[row].charAt(col) - '0';
            queue.add(new int[] {row-1, col});
            queue.add(new int[] {row, col-1});
            queue.add(new int[] {row+1, col});
            queue.add(new int[] {row, col+1});
        }
        
        return cnt;
    }
}