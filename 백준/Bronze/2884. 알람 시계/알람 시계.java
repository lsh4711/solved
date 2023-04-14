import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int H = Integer.parseInt(nums[0]);
        int M = Integer.parseInt(nums[1]);

        if(M < 45) H--;

        System.out.println(String.format("%d %d", (H + 24) % 24, (M + 15) % 60));
    }
}
