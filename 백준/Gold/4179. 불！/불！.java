import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");
        int rowSize = Integer.parseInt(size[0]);
        int colSize = Integer.parseInt(size[1]);
        int[][] board = new int[rowSize][colSize];

        int[] jihun = new int[2];
        ArrayList<int[]> fires = new ArrayList<>();

        for (int i = 0; i < rowSize; i++) {
            char[] cols = br.readLine().toCharArray();
            for (int j = 0; j < colSize; j++) {
                char col = cols[j];
                if (col == '.') {
                    board[i][j] = 0;
                    continue;
                }
                if (col == 'J') {
                    jihun[0] = i;
                    jihun[1] = j;
                    board[i][j] = 0;
                    continue;
                }
                if (col == 'F') {
                    fires.add(new int[]{i, j});
                    board[i][j] = -1;
                    continue;
                }
                board[i][j] = -2;
            }
        }

        int result = bfs(board, jihun, fires);

        if (result == -1) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        System.out.println(result + 1);
    }

    private int bfs(int[][] board, int[] jihun, ArrayList<int[]> fires) {
        int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> jihunRoutes = new LinkedList<>(Collections.singletonList(jihun));
        Queue<int[]> fireRoutes = new LinkedList<>(fires);

        while (!jihunRoutes.isEmpty()) {
            ArrayList<int[]> nextJihunRoutes = new ArrayList<>();

            while (!jihunRoutes.isEmpty()) {
                int[] currentJihun = jihunRoutes.poll();
                int row = currentJihun[0];
                int col = currentJihun[1];
                int time = board[row][col];

                if (time == -1) {
                    continue;
                }
                if (canExit(board, row, col)) {
                    return time;
                }

                for (int[] move : moves) {
                    int nextJihunRow = currentJihun[0] + move[0];
                    int nextJihunCol = currentJihun[1] + move[1];
                    if (!canMove(board, nextJihunRow, nextJihunCol)) {
                        continue;
                    }
                    board[nextJihunRow][nextJihunCol] = time + 1;
                    nextJihunRoutes.add(new int[]{nextJihunRow, nextJihunCol});
                }
            }

            jihunRoutes.addAll(nextJihunRoutes);

            ArrayList<int[]> nextFireRoutes = new ArrayList<>();

            while (!fireRoutes.isEmpty()) {
                int[] fire = fireRoutes.poll();
                for (int[] move : moves) {
                    int nextFireRow = fire[0] + move[0];
                    int nextFireCol = fire[1] + move[1];
                    if (!canFire(board, nextFireRow, nextFireCol)) {
                        continue;
                    }
                    board[nextFireRow][nextFireCol] = -1;
                    nextFireRoutes.add(new int[]{nextFireRow, nextFireCol});
                }
            }

            fireRoutes.addAll(nextFireRoutes);

//            display(board);
        }

        return -1;
    }

    private boolean canMove(int[][] board, int row, int col) {
        return row >= 0 && row < board.length
                && col >= 0 && col < board[row].length
                && board[row][col] == 0;
    }

    private boolean canFire(int[][] board, int row, int col) {
        return row >= 0 && row < board.length
                && col >= 0 && col < board[row].length
                && board[row][col] >= 0;
    }

    private boolean canExit(int[][] board, int row, int col) {
        return row == 0 || row == board.length - 1
                || col == 0 || col == board[row].length - 1;
    }

    private void display(int[][] board) {
        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
