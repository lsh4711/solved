import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    private int[] startPoint;
    private int[] endPoint;
    
    public int solution(String[] board) {
        initPoints(board);
        return getShortestDistance(board);
    }
    
    private void initPoints(String[] board) {
        for (int row = 0; row < board.length; row++) {
            String line = board[row];
            for (int col = 0; col < line.length(); col++) {
                char pointName = line.charAt(col);
                if (pointName == 'R') {
                    startPoint = new int[] {row, col};
                } else if (pointName == 'G') {
                    endPoint = new int[] {row, col};
                }
            }
        }
    }
    
    private int getShortestDistance(String[] board) {
        int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] distanceBoard = new int[board.length][board[0].length()];
        
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] {startPoint[0], startPoint[1]});
        
        while (!deque.isEmpty()) {
            int[] previousPoint = deque.removeFirst();
            int previousDistance = distanceBoard[previousPoint[0]][previousPoint[1]];
            for (int[] move : moves) {
                int[] currentPoint = {previousPoint[0], previousPoint[1]};
                boolean isMoved = false;
                while (true) {
                    int[] nextPoint = getNextPoint(currentPoint, move);
                    if (!isValidPoint(board, nextPoint)) {
                        break;
                    }
                    currentPoint = nextPoint;
                    isMoved = true;
                }
                if (!isMoved) {
                    continue;
                }
                if (board[currentPoint[0]].charAt(currentPoint[1]) == 'G')  {
                    return previousDistance + 1;
                }
                int targetDistance = distanceBoard[currentPoint[0]][currentPoint[1]];
                if (targetDistance == 0 || targetDistance > previousDistance + 1) {
                    distanceBoard[currentPoint[0]][currentPoint[1]] = previousDistance + 1;
                    deque.add(currentPoint);
                }
            }
        }
        return -1;
    }
    
    private int[] getNextPoint(int[] point, int[] move) {
        return new int[] {point[0] + move[0], point[1] + move[1]};
    }
    
    private boolean isValidPoint(String[] board, int[] point) {
        return 0 <= point[0] && point[0] < board.length
                && 0 <= point[1] && point[1] < board[0].length()
                && board[point[0]].charAt(point[1]) != 'D';
    }
    
}
