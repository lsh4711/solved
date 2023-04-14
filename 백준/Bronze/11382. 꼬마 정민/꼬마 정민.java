import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long sum = 0;
        String[] nums = br.readLine().split(" ");

        for(String num : nums) sum += Long.parseLong(num);
        
        System.out.println(sum);
    }
}
