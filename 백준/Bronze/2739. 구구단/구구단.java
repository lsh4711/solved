import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = br.readLine().charAt(0) - 48;
        
        for(int i = 1; i <= 9; i++) System.out.println(String.format("%d * %d = %d", num, i, num * i));
    }
}
