import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] nodes = new ArrayList[n + 1];
        
        for (int i = 0; i <= n; i++) {
            nodes[i] = new ArrayList<>();
            nodes[i].add(0);
        }
        for (int[] line : edge) {
            int a = line[0];
            int b = line[1];
            nodes[a].add(b);
            nodes[b].add(a);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            ArrayList<Integer> node = nodes[now];
            for (int i = 1; i < node.size(); i++) {
                int dest = node.get(i);
                ArrayList<Integer> destNode = nodes[dest];
                if (destNode.get(0) == 0 || destNode.get(0) > node.get(0) + 1) {
                    destNode.set(0, node.get(0) + 1);
                    queue.add(dest);
                }
            }
        }
        int max = 0;
        int cnt = 0;
        
        for (int i = 2; i <= n; i++) {
            int distance = nodes[i].get(0);
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