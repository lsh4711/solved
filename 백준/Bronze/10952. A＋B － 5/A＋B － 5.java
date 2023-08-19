import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new  StringBuilder();

        String line = br.readLine();
        while (line.charAt(0) != '0') {
            String[] nums = line.split(" ");
            int left = Integer.parseInt(nums[0]);
            int right = Integer.parseInt(nums[1]);
            sb.append(left + right).append('\n');
            line = br.readLine();
        }

        System.out.println(sb);
    }
}
