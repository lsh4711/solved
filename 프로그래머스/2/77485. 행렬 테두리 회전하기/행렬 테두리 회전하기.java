class Solution {
    private int[][] board;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] result = new int[queries.length];
        int idx = 0;
        
        initBoard(rows, columns);
        
        for (int[] query : queries) {
            result[idx++] = rotate(query);
        }
        
        return result;
    }
    
    private void initBoard(int rows, int columns) {
        board = new int[rows][columns];
        int num = 1;
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                board[row][col] = num++;
            }
        }
        
    }
    
    private int rotate(int[] query) {
        int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] currentPoint = {query[0] - 1, query[1] - 1};
        
        int previousNum = board[currentPoint[0]][currentPoint[1]];
        int min = previousNum;
        
        for (int[] move : moves) {
            while (true) {
                int[] nextPoint = getNextPoint(currentPoint, move);
                if (!isValidPoint(nextPoint, query)) {
                    break;
                }
                int temp = board[nextPoint[0]][nextPoint[1]];
                board[nextPoint[0]][nextPoint[1]] = previousNum;
                previousNum = temp;
                currentPoint = nextPoint;
                min = Math.min(min, previousNum);
            }
        }
        
        return min;
    }
    
    private int[] getNextPoint(int[] point, int[] move) {
        return new int[] {point[0] + move[0], point[1] + move[1]};
    }
    
    private boolean isValidPoint(int[] point, int[] query) {
        return query[0] - 1 <= point[0] && point[0] < query[2]
            && query[1] - 1 <= point[1] && point[1] < query[3];
    }
}