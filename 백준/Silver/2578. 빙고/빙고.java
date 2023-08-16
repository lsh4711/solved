import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int bingoCnt = 0;
    static int[][] moves = {{0, 1}, {1, 0}, {1, 1}, {-1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[5][5];
        visited = new boolean[5][5];
        int[][] idxs = new int[26][2];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                idxs[num] = new int[] {i, j};
            }
        }

        int cnt = 0;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                int[] coor = idxs[num];
                int row = coor[0];
                int col = coor[1];
                visited[row][col] = true;
                cnt++;
                if (isThreeBingo(row, col, cnt)) {
                    System.out.println(cnt);
                    return;
                }
            }
        }

    }

    private static boolean isThreeBingo(int row, int col, int cnt) {
        isBingo(row, 0, moves[0]);
        isBingo(0, col, moves[1]);
        if (row - col == 0) {
            isBingo(0, 0, moves[2]);
        }
        if (row + col == 4) {
            isBingo(4, 0, moves[3]);
        }

        if (bingoCnt > 2) {
            return true;
        }
        return false;
    }

    private static void isBingo(int row, int col, int[] move) {
        int cnt = 0;

        for (int i = 0; i < 5; i++) {
            boolean isCheck = visited[row][col];
            if (isCheck) {
                cnt++;
            }
            row += move[0];
            col += move[1];
        }
        if (cnt == 5) {
            bingoCnt++;
        }
    }
}
