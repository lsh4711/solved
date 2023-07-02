import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    static PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a1[2] - a2[2]);
    
    public int solution(int n, int[][] costs) {
        ArrayList<int[]>[]  routes = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            routes[i] = new ArrayList<>();
        }
        for (int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int c = cost[2]; 
            routes[a].add(new int[] {a, b, c});
            routes[b].add(new int[] {b, a, c});
        }
        
        return dijkstra(routes);
    }
    
    static int dijkstra(ArrayList<int[]>[] routes) {
        int totalDistance = 0;
        boolean[] visits = new boolean[routes.length];
        visits[0] = true;
        
        for (int[] route : routes[0]) {
            pq.add(route);
        }
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (visits[now[1]]) {
                continue;
            }
            for (int[] route : routes[now[1]]) {
                pq.add(route);
            }
            visits[now[1]] = true;
            totalDistance += now[2];
        }
        
        return totalDistance;
    }
} 