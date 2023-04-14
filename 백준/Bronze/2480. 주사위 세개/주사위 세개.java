import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int[] dice = new int[7];
        String[] nums = br.readLine().split(" ");
        
        for(String num : nums) dice[Integer.parseInt(num)]++;
        for(int i = 6; i > 0; i--) {
            int dot = dice[i];
            if(max == 0 && dot == 1) max = i;
            if(dot < 2) continue;
            if(dot == 2) System.out.println(i * 100 + 1000);
            else System.out.println(i * 1000 + 10000);
            return;
        }

        System.out.println(max * 100);
    }
}
