import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        
        System.out.println(Integer.parseInt(nums[0]) * Integer.parseInt(nums[1]));
    }
}
