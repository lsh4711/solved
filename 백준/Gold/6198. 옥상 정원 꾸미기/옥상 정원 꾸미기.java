import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] buildings = new int[N];

        long total = 0;
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            buildings[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < buildings.length;) {
            if (stack.isEmpty()) {
                stack.add(new int[] {i, buildings[i++]});
            }
            if (i < buildings.length && buildings[i] < stack.peek()[1]) {
                stack.add(new int[] {i, buildings[i++]});
            }
            int end = i == buildings.length ? (int)1e9 : buildings[i];
            while (!stack.isEmpty() && stack.peek()[1] <= end) {
                total += i - stack.pop()[0] - 1;
            }
        }

        System.out.println(total);
    }
}
