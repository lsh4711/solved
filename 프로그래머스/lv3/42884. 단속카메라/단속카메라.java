import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] routes) {
        int cnt = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> arr1[0] - arr2[0]);
        for (int[] route : routes) {
            pq.add(route);
        }
        int[] route = pq.poll();
        
        while (!pq.isEmpty()) {
            int[] nextRoute = pq.poll();
            if (route[1] < nextRoute[0]) {
                route = nextRoute;
                cnt++;
                continue;
            }
            route[0] = nextRoute[0];
            route[1] = Math.min(route[1], nextRoute[1]);
        }
     
        return cnt;
    }
}