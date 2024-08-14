import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int solution(int n, int[][] edge) {
        int[] distances = new int[n + 1];
        ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
        
        for (int i = 0; i <= distances.length; i++) {
            nodes.add(new ArrayList<>());
        }
        
        for (int[] line : edge) {
            int start = line[0];
            int dest = line[1];
            nodes.get(start).add(dest);
            nodes.get(dest).add(start);
        }
        
        return bfs(nodes, distances);
    }
    
    private int bfs(ArrayList<ArrayList<Integer>> nodes, int[] distances) {
        int maxDistance = 0;
        int[] distanceCounts = new int[distances.length];
        Deque<Integer> queue = new LinkedList<>();
        
        Arrays.fill(distanceCounts, 0);
        distances[1] = 0;
        queue.add(1);
        
        while (!queue.isEmpty()) {
            int currentNode = queue.pollFirst();
            int currentDistance = distances[currentNode];
            ArrayList<Integer> dests = nodes.get(currentNode);
            for (int dest : dests) {
                if (dest == 1 || distances[dest] > 0) {
                    continue;
                }
                int nextDistance = currentDistance + 1;
                distances[dest] = nextDistance;
                queue.add(dest);
                maxDistance = Math.max(maxDistance, nextDistance);
                distanceCounts[nextDistance]++;
            }
        }
        
        return distanceCounts[maxDistance];
    }
}
