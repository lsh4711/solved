import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int C, R, K; // 방향 델타 (상 우 하 좌 순서)
    static int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int nowDir = 0; // 현재 방향

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[R][C]; // (1, 1)부터 시작하기 때문에 패딩 1 주었다.
        K = Integer.parseInt(br.readLine()); // 어떤 관객의 대기번호 K
        // 공연장의 좌석을 채우자 (열은 위로 올라가야 한다)
        // 첫자리는 채우고 시작하자

        if (C * R < K) { // 관객을 배정할 수 없다면
            System.out.println(0);
            return;
        }

        fillSeat(0, 0, 1);
    }

    // 재귀로 좌석을 채워보자
    private static void fillSeat(int r, int c, int cnt) {
        arr[r][c] = cnt;
        if (cnt == K) { // 기저 조건 : cnt가 K일 때 종료
            System.out.printf("%d %d", c + 1,  r + 1);
            return;
        }
        int[] delta = deltas[nowDir];
        int nextR = r + delta[0];
        int nextC = c + delta[1];
        if (isInRange(nextR, nextC) && arr[nextR][nextC] == 0) { // 다음 좌표가 범위를 만족하면
            fillSeat(nextR, nextC, cnt + 1);
        } else { // 다음 좌표가 범위를 만족하지 않는다면
            nowDir = (nowDir + 1) % 4; // 방향 전환
            fillSeat(r, c, cnt);
        }
    }

    private static boolean isInRange(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}
