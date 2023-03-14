import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String[] maps) {
        ArrayList<Integer> answer = new ArrayList<>();
        boolean[][] visit = new boolean[maps.length][maps[0].length()];
        
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[0].length(); j++) {
                if(!visit[i][j] && maps[i].charAt(j) != 'X') answer.add(bfs(maps, visit, i, j));
            }
        }
        answer.sort(null);
        if(answer.size() == 0) answer.add(-1);
        
        return answer;
    }
    
    static int bfs(String[] maps, boolean[][] visit, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] move = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int food = 0;
        
        queue.add(new int[] {i, j});
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int row = poll[0];
            int col = poll[1];
            if(row<0 || col<0 || row>=visit.length || col>=visit[0].length || visit[row][col] || maps[row].charAt(col) == 'X') continue;
            food += maps[row].charAt(col) - '0';
            visit[row][col] = true;
            for(int[] m : move) queue.add(new int[] {row+m[0], col+m[1]});
        }
        
        if(food == 0) return -1;
        return food;
    }
}