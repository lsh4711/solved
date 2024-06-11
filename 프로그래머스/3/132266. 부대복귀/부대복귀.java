import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        ArrayList<Integer>[] graph = initGraph(roads, n);
        int[] result = new int[sources.length];
        int[] distances = getDistances(graph, destination);
        int idx = 0;
        
        for (int source : sources) {
            int distance = distances[source];
            result[idx++] = distance - 1;
        }
        
        return result;
    }
    
    private ArrayList<Integer>[] initGraph(int[][] roads, int n) {
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] road : roads) {
            int start = road[0];
            int dest = road[1];
            graph[start].add(dest);
            graph[dest].add(start);
        }
        
        return graph;
    }
    
    private int[] getDistances(ArrayList<Integer>[] graph, int destination) {
        Deque<Integer> queue = new LinkedList<>();
        queue.add(destination);
        
        int[] distances = new int[graph.length];
        distances[destination] = 1;
        
        while (!queue.isEmpty()) {
            int start = queue.poll();
            for (int dest : graph[start]) {
                if (distances[dest] > 0) {
                    continue;
                }
                distances[dest] = distances[start] + 1;
                queue.add(dest);
            }
        }
        
        return distances;
    }
}