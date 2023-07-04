import java.util.PriorityQueue;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int[] nums = new int[101];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < rank.length; i++) {
            boolean exists = attendance[i];
            if (exists) {
                int now = rank[i];
                nums[now] = i;
                pq.add(now);    
            }
        }
        int a = nums[pq.poll()];
        int b = nums[pq.poll()];
        int c = nums[pq.poll()];
        
        return 10000 * a + 100 * b + c;
    }
}