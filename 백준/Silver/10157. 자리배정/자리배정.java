import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int C = Integer.parseInt(split[0]);
        int R = Integer.parseInt(split[1]);
        int K = Integer.parseInt(br.readLine());
        boolean[][] visits = new boolean[R][C];

        if (C * R < K) {
            System.out.println(0);
            return;
        }

        int num = 1;
        int row = -1;
        int col = 0;
        int direction = 0;
        int[][] moves = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (true) {
            int[] move = moves[direction];
            int nextRow = row + move[0];
            int nextCol = col + move[1];
            if (!isInRange(C, R, nextRow, nextCol) || visits[nextRow][nextCol]) {
                direction++;
                if (direction == 4) {
                    direction = 0;
                }
                continue;
            }
            visits[nextRow][nextCol] = true;
            if (num++ == K) {
                System.out.printf("%d %d", nextCol + 1, nextRow + 1);
                return;
            }
            row = nextRow;
            col = nextCol;
        }

    }

    static boolean isInRange(int C, int R, int row, int col) {
        if (row < 0 || col < 0 || row >= R || col >= C) {
            return false;
        }
        return true;
    }
}
