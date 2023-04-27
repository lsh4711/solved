import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int cnt = -1;
            int[] nums = new int[4];
            String[] strs = br.readLine().split(" ");
            for(int j = 0; j < 4; j++) nums[j] = Integer.parseInt(strs[j]);
            for(int k = 0; true; k++) {
                int temp = nums[0] * k + nums[2];
                if(temp > nums[0] * nums[1]) break;
                if((temp - 1) % nums[1] + 1 != nums[3]) continue;
                cnt = temp;
                break;
            }
            System.out.println(cnt);
        }
    }
}
