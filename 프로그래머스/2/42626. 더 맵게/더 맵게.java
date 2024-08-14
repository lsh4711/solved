import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scovilles, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt = 0;
        int totalScoville = 0;
        
        for (int scoville : scovilles) {
            pq.add(scoville);
        }
        
        while (true) {
            int first = pq.poll();
            if (first >= K) {
                return cnt;
            }
            if (pq.isEmpty()) {
                return -1;
            }
            int second = pq.poll();
            pq.add(first + (second * 2));
            cnt++;
        }
        
    }
}