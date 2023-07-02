import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    static PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a1[2] - a2[2]);
    
    public int solution(int n, int[][] costs) {
        ArrayList<int[]>[]  routes = new ArrayList[n];
        
        for (int i = 0; i < n; i++) {
            routes[i] = new ArrayList<>();
        }
        for (int i = 0; i < costs.length; i++) {
            int[] cost = costs[i];
            int a = cost[0];
            int b = cost[1];
            int c = cost[2]; 
            routes[a].add(new int[] {b, c});
            routes[b].add(new int[] {a, c});
        }
        for (int[] route : routes[0]) {
            pq.add(new int[] {0, route[0], route[1]});
        }
        boolean[] visits = new boolean[n];
        visits[0] = true;
        
        int totalDistance = dijkstra(routes, visits);
        
        return totalDistance;
    }
    
    static int dijkstra(ArrayList<int[]>[] routes, boolean[] visits) {
        int totalDistance = 0;
        
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (visits[now[1]]) {
                continue;
            }
            for (int[] route : routes[now[1]]) {
                pq.add(new int[] {now[1], route[0], route[1]});
            }
            visits[now[1]] = true;
            totalDistance += now[2];
        }
        
        return totalDistance;
    }
}