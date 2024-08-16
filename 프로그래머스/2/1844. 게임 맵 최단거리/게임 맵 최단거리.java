import java.util.Deque;
import java.util.LinkedList;

class Solution {
    private int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int solution(int[][] maps) {
        int result = bfs(maps);
        return result;
    }
    
    private int bfs(int[][] maps) {
        int[][] distances = new int[maps.length][maps[0].length];
        Deque<int[]> queue = new LinkedList<>();
        
        queue.add(new int[] {0, 0});
        
        while (!queue.isEmpty()) {
            int[] current = queue.removeFirst();
            int row = current[0];
            int col = current[1];
            int distance = distances[row][col];
            if (row == maps.length - 1
               && col == maps[row].length - 1) {
                return distance + 1;
            }
            for (int[] move : moves) {
                int nextRow = row + move[0];
                int nextCol = col + move[1];
                if (!canMove(maps, nextRow, nextCol, distances)) {
                    continue;
                }
                distances[nextRow][nextCol] = distance + 1;
                queue.add(new int[] {nextRow, nextCol});
            }
        }
        
        return -1;
    }
    
    private boolean canMove(int[][] maps, int row, int col, int[][] distances) {
        return (row != 0 || col != 0)
            && 0 <= row && row < maps.length
            && 0 <= col && col < maps[row].length
            && maps[row][col] == 1
            && distances[row][col] == 0;
    }
}