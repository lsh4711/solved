import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;

public class Main {
    private static int totalChickenDistance = (int)1e9;
    private static ArrayList<int[]> homes = new ArrayList<>();
    private static ArrayList<int[]> chickens = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        for (int row = 0; row < N; row++) {
            String[] blocks = br.readLine().split(" ");
            for (int col = 0; col < N; col++) {
                int blockNum = Integer.parseInt(blocks[col]);
                if (blockNum == 1) {
                    homes.add(new int[] {row, col});
                } else if (blockNum == 2) {
                    chickens.add(new int[] {row, col});
                }
            }
        }

        dfs(M, chickens.size(), -1);
        System.out.println(totalChickenDistance);
    }

    private static void dfs(int M, int surviveChickenCnt, int idx) {
        if (M >= surviveChickenCnt) {
            updateTotalChickenDistance(homes, chickens);
            return;
        }

        for (int i = 0; i < chickens.size(); i++) {
            if (i <= idx) {
                continue;
            }
            int[] chicken = chickens.get(i);
            chickens.set(i, null);
            dfs(M, surviveChickenCnt - 1, i);
            chickens.set(i, chicken);
        }

    }

    private static void updateTotalChickenDistance(ArrayList<int[]> homes, ArrayList<int[]> chickens) {
        int sum = 0;

        for (int[] home : homes) {
            int minDistance = (int)1e9;
            for (int[] chicken : chickens) {
                if (chicken == null) {
                    continue;
                }
                minDistance = Math.min(minDistance, getChickenDistance(home[0], home[1], chicken[0], chicken[1]));
            }
            sum += minDistance;
        }
        totalChickenDistance = Math.min(totalChickenDistance, sum);
    }

    private static int getChickenDistance(int homeRow, int homeCol, int chickenRow, int chickenCol) {
        return Math.abs(homeRow - chickenRow) + Math.abs(homeCol - chickenCol);
    }
}
