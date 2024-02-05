import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private int fib_dp(int n) {
        int minus1 = 1;
        int num = 1;

        for (int i = 3; i <= n; i++) {
            int temp = num;
            num = (minus1 + num) % 1000000007;
            minus1 = temp;
        }

        return num;
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
