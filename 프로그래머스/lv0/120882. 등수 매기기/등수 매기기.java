import java.util.PriorityQueue;

class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        int[] before = new int[2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a2[0] - a1[0]);

        for(int i=0; i<score.length; i++) pq.add(new int[] {(score[i][0]+score[i][1]), i});
        for(int i=0; i<answer.length; i++) {
            int[] poll = pq.poll();
            if(before[0] == poll[0]) answer[poll[1]] = before[1] + 1;
            else {
                answer[poll[1]] = i + 1;
                before = new int[] {poll[0], i};
            }
        }
        
        return answer;
    }
}