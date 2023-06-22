import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line.equals("0")) {
                break;
            }
            String[] split = line.split(" ");
            int[] histogram = new int[split.length - 1];
            for (int i = 1; i < split.length; i++) {
                histogram[i - 1] = Integer.parseInt(split[i]);
            }

            long max = 0;
            Stack<int[]> left = new Stack<>();

            for (int i = 0; i < histogram.length;) {
                if (left.isEmpty()) {
                    left.push(new int[] {histogram[i], i});
                    i++;
                }
                while (i < histogram.length && left.peek()[0] <= histogram[i]) {
                    if (left.peek()[0] < histogram[i]) {
                        left.push(new int[] {histogram[i], i});
                    }
                    i++;
                }
                int prevIdx = 0;
                int next = i < histogram.length ? histogram[i] : 0;

                while (!left.isEmpty() && left.peek()[0] > next) {
                    int[] top = left.pop();
                    long height = top[0];
                    long width = i - top[1];
                    long area = height * width;
                    if (max < area) {
                        max = area;
                    }
                    prevIdx = top[1];
                }
                if (left.isEmpty() || left.peek()[0] < next) {
                    left.push(new int[] {next, prevIdx});
                }
            }
            result.append(max).append('\n');
        }

        System.out.println(result);
    }
}
