import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    static int max = (int)1e9;

    public int solution(int[][] board) {
        int N = board.length;
        int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        int[][][] routes = new int[N][N][4];
        routes[0][0] = new int[] {1, 1, 1, 1};

        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a1[2] - a2[2]);
        pq.add(new int[] {0, 0, 0});

        ArrayList<int[]> costList = new ArrayList<>();

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int row = now[0];
            int col = now[1];
            costList.clear();
            addCostsAndSort(costList, routes[row][col]);
            for (int i = 0; i < 4; i++) {
                int[] move = moves[i];
                int nextRow = row + move[0];
                int nextCol = col + move[1];
                int min = getMinCost(costList, i);
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
            if (0 < cost && cost < min) {
                min = cost;
            }
        }
        
        return min - 1;
    }
    
    static void addCostsAndSort(ArrayList<int[]> costList, int[] costs) {
        for (int i = 0; i < 4; i++) {
            int cost = costs[i];
            if (cost > 0) {
                costList.add(new int[] {i, cost});
            }
        }
        costList.sort((a1, a2) -> a1[1] - a2[1]);
    }
    
    static int getMinCost(ArrayList<int[]> costList, int direction) {
        int min = max;

        for (int[] costInfo : costList) {
            int cost = costInfo[1] + 100;
            if (costInfo[0] != direction) {
                cost += 500;
            }
            if (cost < min) {
                min = cost;
            }
        }

        return min;
    }
}