import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][2];

        if (N % 3 == 0) {
            dp[N / 3] = new int[] {1, N};
        }
        if (N % 2 == 0) {
            dp[N / 2] = new int[] {1, N};
        }
        dp[N - 1] = new int[] {1, N};

        for (int i = N; i >= 1; i--) {
            int[] now = dp[i];
            if (now[0] == 0) {
                continue;
            }
            int idx = i;
            if (i % 3 == 0) {
                if (dp[i / 3][0] == 0) {
                    dp[i / 3] = new int[] {now[0] + 1, i};
                } else if (now[0] + 1 < dp[i / 3][0]) {
                    dp[i / 3] = new int[] {now[0] + 1, i};
                }
            }
            if (i % 2 == 0) {
                if (dp[i / 2][0] == 0) {
                    dp[i / 2] = new int[] {now[0] + 1, i};
                } else if (now[0] + 1 < dp[i / 2][0]) {
                    dp[i / 2] = new int[] {now[0] + 1, i};
                }
            }
            if (dp[i - 1][0] == 0) {
                dp[i - 1] = new int[] {now[0] + 1, i};
            } else if (now[0] + 1 < dp[i - 1][0]) {
                dp[i - 1] = new int[] {now[0] + 1, i};
            }
        }
        StringBuilder result = new StringBuilder();
        result.append(1);
        int idx = 1;
        while (idx < N) {
            int[] now = dp[idx];
            result.insert(0, now[1] + " ");
            idx = now[1];
        }
        result.insert(0, dp[1][0] + "\n");

        System.out.println(result);
    }
}
