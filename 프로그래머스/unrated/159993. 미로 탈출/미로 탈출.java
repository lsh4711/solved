import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(String[] maps) {
        int totalDistance = 0;
        int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                char now = maps[i].charAt(j);
                if (now == 'S' || now == 'L') {
                    char dest = now == 'S' ? 'L' : 'E';
                    boolean[][] visits = new boolean[maps.length][maps[0].length()];
                    int distance = toDest(maps, visits, moves, i, j, dest);
                    if (distance == -1) {
                        return -1;
                    }
                    totalDistance += distance;
                }
            }
        }
        
        return totalDistance;
    }
    
    static int toDest(String[] maps, boolean[][] visits, int[][] moves, int row, int col, char dest) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, col, 0});
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (maps[now[0]].charAt(now[1]) == dest) {
                return now[2];
            }
            for (int i = 0; i < 4; i++) {
                int[] move = moves[i];
                row = now[0] + move[0];
                col = now[1] + move[1];
                if (row < 0 || col < 0 || row >= maps.length || col >= maps[0].length()
                        || visits[row][col] || maps[row].charAt(col) == 'X') {
                    continue;
                }
                visits[row][col] = true;
                queue.add(new int[] {row, col, now[2] + 1});
            }
        }
        
        return -1;
    }
}