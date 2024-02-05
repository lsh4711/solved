import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private int fib_dp(int n) {
        int[] f = new int[n+1];

        f[1] = f[2] = 1;

        for (int i = 3; i <= n; i++) {
            f[i] = (f[i-1] + f[i-2]) % 1000000007;
        }

        return f[n];
    }

    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int intN = Integer.parseInt(br.readLine());

        System.out.println(fib_dp(intN) + " " + (intN - 2));
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
