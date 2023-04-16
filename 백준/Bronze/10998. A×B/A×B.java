import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nums = br.readLine();
        
        System.out.println((nums.charAt(0) - 48) * (nums.charAt(2) - 48));
    }
}
