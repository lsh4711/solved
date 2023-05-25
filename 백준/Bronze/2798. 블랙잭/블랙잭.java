import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine().split(" ")[1]);
        String[] arr = br.readLine().split(" ");
        int[] cards = new int[arr.length];
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            cards[i] = Integer.parseInt(arr[i]);
        }
        for (int i = 0; i < cards.length - 2; i++) {
            int first = cards[i];
            for (int j = i + 1; j < cards.length - 1; j++) {
                int second = first + cards[j];
                for (int k = j + 1; k < cards.length; k++) {
                    int third = second + cards[k];
                    if (M >= third && max < third) {
                        max = third;
                    }
                }
            }
        }

        System.out.println(max);
    }
}
