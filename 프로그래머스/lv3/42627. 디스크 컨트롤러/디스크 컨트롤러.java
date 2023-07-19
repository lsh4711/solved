import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        int result = 0;
        int realTime = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a1[1] - a2[1]);
        
        Arrays.sort(jobs, (a1, a2) -> {
            if (a1[0] != a2[0]) {
                return a1[0] - a2[0];
            }
            return a1[1] - a2[1];
        }); 
        for (int[] job : jobs) {
            while (job[0] > realTime && !pq.isEmpty()) {
                int[] poll = pq.poll();
                result += realTime - poll[0] + poll[1];
                realTime += poll[1];
            }
            if (job[0] <= realTime) {
                pq.add(job);
                continue;
            }
            result += job[1];
            realTime = job[0] + job[1];
        }
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            result += realTime - poll[0] + poll[1];
            realTime += poll[1];
        }
        
        return result / jobs.length;
    }
} 