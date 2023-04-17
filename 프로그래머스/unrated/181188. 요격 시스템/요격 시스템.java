import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] targets) {
        int cnt = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> arr1[1] - arr2[1]);
        
        for(int[] target : targets) pq.add(target);
        while(!pq.isEmpty()) {
            int[] target = pq.poll();
            while(!pq.isEmpty()) {
                int[] nextTarget = pq.peek();
                if(target[1] <= nextTarget[0]) break;
                pq.poll();
            }
            cnt++;
        }
        
        return cnt;
    }
}