import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = br.readLine().charAt(0) - 48;
        
        for(int i = 1; i <= 9; i++) sb.append(num).append(" * ").append(i).append(" = ").append(num * i).append("\n");
        
        System.out.println(sb);
    }
}
