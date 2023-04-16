import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-- != 0) {
            String[] nums = br.readLine().split(" ");
            sb.append(Integer.parseInt(nums[0]) + Integer.parseInt(nums[1])).append('\n');
        }
        
        System.out.println(sb);
    }
}
