import java.util.Deque;
import java.util.LinkedList;

class Solution {
    private int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int solution(int[][] rectangles, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[51 * 2][51 * 2];
        
        for (int[] rectangle : rectangles) {
            fillMap(map, rectangle);
        }
        
        int result = bfs(map, characterX, characterY, itemX, itemY);
        
        return result;
    }
    
    private void fillMap(int[][] map, int[] rectangle) {
        for (int row = rectangle[1] * 2; row <= rectangle[3] * 2; row++) {
            for (int col = rectangle[0] * 2; col <= rectangle[2] * 2; col++) {
                if (map[row][col] == -1) {
                    continue;
                }
                map[row][col] = isLine(rectangle, row, col) ? 1 : -1;
            }
        }
        
    }
    
    private boolean isLine(int[] rectangle, int row, int col) {
        return row == rectangle[1] * 2 || row == rectangle[3] * 2 
            || col == rectangle[0] * 2 || col == rectangle[2] * 2;
    }
    
    private int bfs(int[][] map, int characterX, int characterY, int itemX, int itemY) {
        int[] character = {characterY * 2, characterX * 2};
        int[] item = {itemY * 2, itemX * 2};
        Deque<int[]> queue = new LinkedList<>();
        
        map[character[0]][character[1]] = 0;
        queue.add(character);
        
        while (!queue.isEmpty()) {
            int[] currentCharacter = queue.removeFirst();
            int row = currentCharacter[0];
            int col = currentCharacter[1];
            int distance = map[row][col];
            if (row == item[0] && col == item[1]) {
                return distance / 2;
            }
            for (int[] move : moves) {
                int nextRow = row + move[0];
                int nextCol = col + move[1];
                if (!canMove(map, nextRow, nextCol)) {
                    continue;
                }
                map[nextRow][nextCol] = distance + 1;
                queue.add(new int[] {nextRow, nextCol});
            }
        }
        
        return 0;
    }
    
    private boolean canMove(int[][] map, int row, int col) {
        return 0 <= row && row < map.length
            && 0 <= col && col < map[row].length
            && map[row][col] == 1;
    }
}