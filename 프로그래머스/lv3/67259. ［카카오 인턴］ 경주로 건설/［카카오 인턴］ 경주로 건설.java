import java.util.Arrays;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] board) {
        int N = board.length;
        int max = (int)1e9;
        int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][][] routes = new int[N][N][4];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int[] costs = routes[i][j];
                Arrays.fill(costs, max);
            }
        }
        Arrays.fill(routes[0][0], 0);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a1[2] - a2[2]);
        pq.add(new int[] {0, 0, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int row = now[0];
            int col = now[1];
            for (int i = 0; i < 4; i++) {
                int[] move = moves[i];
                int nextRow = row + move[0];
                int nextCol = col + move[1];
                int min = getMinCost(routes[row][col], i, max);
                if (nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= N || board[nextRow][nextCol] == 1
                        || routes[nextRow][nextCol][i] != 0 && routes[nextRow][nextCol][i] <= min) {
                    continue;
                }
                routes[nextRow][nextCol][i] = min;
                pq.add(new int[] {nextRow, nextCol, min});
            }
        }

        int min = max;
        
        for (int cost : routes[N - 1][N - 1]) {
            if (cost < min) {
                min = cost;
            }
        }
        
        return min;
    }
    
    static int getMinCost(int[] costs, int direction, int min) {
        for (int i = 0; i < 4; i++) {
            int cost = i == direction ? costs[i] + 100 : costs[i] + 600;
            if (cost < min) {
                min = cost;
            }
        }

        return min;
    }
}