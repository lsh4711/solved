import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(String[] maps) {
        int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int i = 0; true; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) != 'L') {
                    continue;
                }
                boolean[][] visits = new boolean[maps.length][maps[0].length()];
                return calculateTime(maps, visits, moves, i, j);
            }
        }
        
    }
    
    static int calculateTime(String[] maps, boolean[][] visits, int[][] moves, int row, int col) {
        int timeFromStart = -1;
        int timeToEnd = -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, col, 0});
        
        while (timeFromStart == -1 || timeToEnd == -1) {
            if (queue.isEmpty()) {
                return -1;
            }
            int[] now = queue.poll();
            int nowObject = maps[now[0]].charAt(now[1]);
            if (nowObject == 'S') {
                timeFromStart = now[2];
            } else if (nowObject == 'E') {
                timeToEnd = now[2];
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
        
        return timeFromStart + timeToEnd;
    }
}