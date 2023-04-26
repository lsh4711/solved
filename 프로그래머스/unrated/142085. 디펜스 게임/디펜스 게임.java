import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < enemy.length; i++) {
            int headCnt = enemy[i];
            if(pq.size() < k || pq.peek() <= headCnt) pq.add(headCnt);
            else n -= headCnt;
            if(pq.size() > k) n -= pq.poll();
            if(n < 0) return i;
        }
        
        return enemy.length;
    }
}