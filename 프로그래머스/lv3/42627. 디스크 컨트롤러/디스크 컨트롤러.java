import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        int result = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a1[1] - a2[1]);
        
        Arrays.sort(jobs, (a1, a2) -> {
            if (a1[0] != a2[0]) {
                return a1[0] - a2[0];
            }
            return a1[1] - a2[1];
        });

        int time = -1;
        
        for (int[] job : jobs) {
            while (job[0] > time && !pq.isEmpty()) {
                int[] poll = pq.poll();
                result += time - poll[0] + poll[1];
                time += poll[1];
            }
            if (job[0] <= time) { // < vs <=
                pq.add(job);
                continue;
            }
            if (pq.isEmpty()) {
                result += job[1];
                time = job[0] + job[1];
                continue;
            }
        }
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            result += time - poll[0] + poll[1];
            time += poll[1];
        }
        
        return result / jobs.length;
    }
}