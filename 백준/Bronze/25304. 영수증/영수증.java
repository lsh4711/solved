import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(br.readLine());
        int cnt = Integer.parseInt(br.readLine());

        for(int i = 0; i < cnt; i++) {
            String[] nums = br.readLine().split(" ");
            total -= Integer.parseInt(nums[0]) * Integer.parseInt(nums[1]);
        }

        if(total == 0) System.out.println("Yes");
        else System.out.println("No");
    }
}
