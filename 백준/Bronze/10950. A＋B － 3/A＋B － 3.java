import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < cnt; i++) {
            String nums = br.readLine();
            sb.append(nums.charAt(0) + nums.charAt(2) - 96).append("\n");
        }
        
        System.out.println(sb);
    }
}
