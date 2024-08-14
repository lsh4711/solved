import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((job1, job2) -> job1[1] - job2[1]);
        int totalWaitingTime = 0;
        int realtime = 0;
        int idx = 0;
        
        Arrays.sort(jobs, (job1, job2) -> {
            return job1[0] == job2[0]
                ? job1[1] - job2[1]
                : job1[0] - job2[0];
        });
        
        while (true) {
            while (idx < jobs.length
                   && jobs[idx][0] < realtime) {
                Integer[] job = {jobs[idx][0], jobs[idx][1]};
                pq.add(job);
                idx++;
            }
            if (pq.isEmpty()) {
                if (idx >= jobs.length) {
                    break;
                }
                int[] job = jobs[idx++];
                realtime = job[0] + job[1];
                totalWaitingTime += job[1];
                continue;
            }
            Integer[] job = pq.poll();
            totalWaitingTime += realtime + job[1] - job[0];
            System.out.println(job[1]); 
            System.out.println(realtime + job[1] - job[0]);
            realtime += job[1];
        }
        
        return totalWaitingTime / jobs.length;
    }
}