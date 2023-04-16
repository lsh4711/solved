import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 1; i <= T; i++) {
            String nums = br.readLine();
            int A = nums.charAt(0) - 48;
            int B = nums.charAt(2) - 48;
            sb.append("Case #").append(i).append(": ").append(A).append(" + ").append(B)
                    .append(" = ").append(A + B).append("\n");
        }
        
        System.out.println(sb);
    }
}
