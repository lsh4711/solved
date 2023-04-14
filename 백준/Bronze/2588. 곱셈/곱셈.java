import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int multi = A * B;

        for(; B != 0; B /= 10) System.out.println(B % 10 * A);
        
        System.out.println(multi);
    }
}
