import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        
        for (char c : line.toCharArray()) {
            sb.append(c).append('\n');
        }
        
        System.out.println(sb);
    }
}