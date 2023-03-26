import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int max = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        pq.add(0);
        Arrays.sort(book_time, (arr1, arr2) -> arr1[0].compareTo(arr2[0]));
        for(String[] time : book_time) {
            int start = Integer.parseInt(time[0].replace(":", ""));
            int end = Integer.parseInt(time[1].replace(":", "")) + 10;
            if(end % 100 >= 60) end += 40;
            if(start - pq.peek() < 0) pq.add(end);
            else {
                pq.poll();
                pq.add(end);
            }
            max = Math.max(max, pq.size());
        }
        
        return max;
    }
}