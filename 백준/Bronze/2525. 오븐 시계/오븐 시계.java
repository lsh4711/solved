import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int A = Integer.parseInt(nums[0]);
        int B = Integer.parseInt(nums[1]);
        int min = B + Integer.parseInt(br.readLine());

        System.out.println(String.format("%d %d", (A + min / 60) % 24, min % 60));
    }
}
