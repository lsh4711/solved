import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int B = Integer.parseInt(split[1]);
        
        String result = Integer.toString(N, B).toUpperCase();

        System.out.println(result);
    }
}
