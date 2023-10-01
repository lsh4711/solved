import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        ArrayList<int[]>[] nodes = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int[] fare : fares) {
            int start = fare[0];
            int dest = fare[1];
            int cost = fare[2];
            nodes[start].add(fare);
            nodes[dest].add(new int[] {dest, start, cost});
        }
        
        int[][] costs = new int[n + 1][3];
        
        dijkstra(nodes, costs, new boolean[n + 1], s, 0);
        dijkstra(nodes, costs, new boolean[n + 1], a, 1);
        dijkstra(nodes, costs, new boolean[n + 1], b, 2);
        
        int min = (int)2e9;
        
        for (int i = 1; i < costs.length; i++) {
            int[] cost = costs[i];
            int totalCost = cost[0] + cost[1] + cost[2];
            if (totalCost != 0 && totalCost < min) {
                min = totalCost;
            }
        }
        
        return min;
    }
    
    static void dijkstra(ArrayList<int[]>[] nodes, int[][] costs, boolean[] visits, int source, int idx) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a1[2] - a2[2]);
        pq.addAll(nodes[source]);
        
        visits[source] = true;
        while (!pq.isEmpty()) {
            int[] route = pq.poll();
            int start = route[0];
            int dest = route[1];
            int cost = route[2];
            if (visits[dest]) {
                continue;
            }
            visits[dest] = true;
            costs[dest][idx] = cost;
            ArrayList<int[]> destNode = nodes[dest];
            for (int i = 0; i < destNode.size(); i++) {
                int[] nextRoute = destNode.get(i).clone();
                nextRoute[2] += costs[dest][idx];
                pq.add(nextRoute);
            }
        }
        
    }
} 