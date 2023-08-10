import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] board) {
        int N = board.length;
        int maxCost = (int)1e9;
        int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int[][][] routes = new int[N][N][4];
        routes[0][0] = new int[] {1, 1, 1, 1};

        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a1[2] - a2[2]);
        pq.add(new int[] {0, 0, 0});

        ArrayList<int[]> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int row = now[0];
            int col = now[1];
            int totalCost = now[2];

            for (int i = 0; i < 4; i++) {
                int cost = routes[row][col][i];
                if (cost == 0) {
                    continue;
                }
                list.add(new int[] {i, cost});
            }
            list.sort((a1, a2) -> a1[1] - a2[1]);

            for (int i = 0; i < 4; i++) {
                int[] move = moves[i];
                int nextRow = row + move[0];
                int nextCol = col + move[1];
                int minCost = maxCost;
                for (int[] costInfo : list) {
                    int cost = costInfo[1] + 100;
                    if (costInfo[0] != i) {
                        cost += 500;
                    }
                    if (cost < minCost) {
                        minCost = cost;
                    }
                }
                if (nextRow < 0 || nextCol < 0 || nextRow >= N || nextCol >= N || board[nextRow][nextCol] == 1
                        || routes[nextRow][nextCol][i] != 0 && routes[nextRow][nextCol][i] <= minCost) {
                    continue;
                }
                routes[nextRow][nextCol][i] = minCost;
                pq.add(new int[] {nextRow, nextCol, minCost});
            }
            list.clear();
        }

        int minCost = maxCost;
        
        for (int r : routes[N - 1][N - 1]) {
            if (r != 0 && r < minCost) {
                minCost = r;
            }
        }
        
        return minCost - 1;
    }
}