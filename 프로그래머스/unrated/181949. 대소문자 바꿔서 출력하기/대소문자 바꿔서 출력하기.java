import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder sb = new StringBuilder();
        
        for (char c : str.toCharArray()) {
            if (c >= 97) {
                c -= 32;
            } else {
                c += 32;
            }
            sb.append(c);
        }
        
        System.out.println(sb);
    }
}