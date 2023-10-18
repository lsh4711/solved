import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] nodes = new ArrayList[n + 1];
        
        for (int i = 0; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int[] line : edge) {
            int a = line[0];
            int b = line[1];
            nodes[a].add(b);
            nodes[b].add(a);
        }
        int[] distances = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            ArrayList<Integer> node = nodes[now];
            for (int dest : node) {
                if (distances[dest] == 0 || distances[dest] > distances[now] + 1) {
                    distances[dest] = distances[now] + 1;
                    queue.add(dest);
                }
            }
        }
        int max = 0;
        int cnt = 0;
        
        for (int i = 2; i <= n; i++) {
            int distance = distances[i];
            if (distance > max) {
                max = distance;
                cnt = 1;
            } else if (distance == max) {
                cnt++;
            }
        }
        
        return cnt;
    }
}