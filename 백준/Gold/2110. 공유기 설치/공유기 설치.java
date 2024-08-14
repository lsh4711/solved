import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        int[] houses = new int[N];

        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        if (C == 2) {
            System.out.println(houses[houses.length - 1] - houses[0]);
            return;
        }

        int result = binarySearch(houses, C);

        System.out.println(result);
    }

    private int binarySearch(int[] houses, int routers) {
        int start = 0;
        int end = houses[houses.length - 1] - houses[0];

        while (start < end) {
            int mid = (start + end) / 2;
            if (canInstall(houses, routers - 1, mid)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start - 1;
    }

    private boolean canInstall(int[] houses, int routers, int minDistance) {
        int previousHouse = houses[0];

        for (int house : houses) {
            if (house - previousHouse < minDistance) {
                continue;
            }
            previousHouse = house;
            if (--routers == 0) {
                return true;
            }
        }

        return false;
    }

}
