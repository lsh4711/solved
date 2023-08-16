import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] visited;

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
                if (isThreeBingo()) {
                    System.out.println(cnt);
                    return;
                }
            }
        }

    }

    private static boolean isThreeBingo() {
        int bingoCnt = 0;

        // 세로
        for (int i = 0; i < 5; i++) {
            int tmpCnt = 0;
            for (int r = 0; r < 5; r++) {
                if (visited[r][i] == false) {
                    continue;
                } else {
                    tmpCnt++;
                }
                if (tmpCnt == 5) {
                    bingoCnt++;
                }
            }
        }

        // 가로
        for (int i = 0; i < 5; i++) {
            int tmpCnt = 0;
            for (int c = 0; c < 5; c++) {
                if (visited[i][c] == false) {
                    continue;
                } else {
                    tmpCnt++;
                }
                if (tmpCnt == 5) {
                    bingoCnt++;
                }
            }
        }

        // 대각선
        int tmpCnt = 0;
        for (int i = 0; i < 5; i++) {
            if (visited[i][i] == true) {
                tmpCnt++;
            } else {
                break;
            }
            if (tmpCnt == 5) {
                bingoCnt++;
            }
        }

        // 대각선
        tmpCnt = 0;
        for (int i = 0; i < 5; i++) {
            if (visited[i][4 - i] == true) {
                tmpCnt++;
            } else {
                break;
            }
            if (tmpCnt == 5) {
                bingoCnt++;
            }
        }

        if (bingoCnt > 2) {
            return true;
        }
        return false;
    }
}
