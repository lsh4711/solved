import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int result = (int)1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        int[][] city = new int[N][N];
        ArrayList<int[]> chickens = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] blocks = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int blockNum = Integer.parseInt(blocks[j]);
                if (blockNum == 2) {
                    chickens.add(new int[] {i, j});
                }
                city[i][j] = blockNum;
            }
        }

        dfs(city, chickens, M, chickens.size(), -1);
        System.out.println(result);
    }

    private static void dfs(int[][] city, ArrayList<int[]> chickens, int M, int chickenCnt, int idx) {
        if (M == chickenCnt) {
            int totalChickenDistance = calculateTotalChickenDistance(city);
            if (totalChickenDistance < result) {
                result = totalChickenDistance;
            }
            return;
        }

        for (int i = 0; i < chickens.size(); i++) {
            if (i <= idx) {
                continue;
            }
            int[] chicken = chickens.get(i);
            city[chicken[0]][chicken[1]] = 0;
            dfs(city, chickens, M, chickenCnt - 1, i);
            city[chicken[0]][chicken[1]] = 2;
        }

    }

    private static int calculateTotalChickenDistance(int[][] city) {
        int N = city.length;
        int totalChickenDistance = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int blockNum = city[i][j];
                if (blockNum == 1) {
                    totalChickenDistance += getNearestChickenDistance(city, i, j);
                }
            }
        }

        return totalChickenDistance;
    }

    private static int getNearestChickenDistance(int[][] city, int row, int col) {
        int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] visitMap = new boolean[city.length][city.length];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, col});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentRow = poll[0];
            int currentCol = poll[1];
            if (city[currentRow][currentCol] == 2) {
                return getChickenDistance(row, col, currentRow, currentCol);
            }
            for (int[] move : moves) {
                int nextRow = currentRow + move[0];
                int nextCol = currentCol + move[1];
                if (!isInRange(city.length, nextRow, nextCol) || visitMap[nextRow][nextCol]) {
                    continue;
                }
                visitMap[nextRow][nextCol] = true;
                queue.add(new int[] {nextRow, nextCol});
            }
        }

        return 0;
    }

    private static boolean isInRange(int length, int row, int col) {
        return 0 <= row && row < length
                && 0 <= col && col < length;
    }

    private static int getChickenDistance(int homeRow, int homeCol, int chickenRow, int chickenCol) {
        return Math.abs(homeRow - chickenRow) + Math.abs(homeCol - chickenCol);
    }
}
