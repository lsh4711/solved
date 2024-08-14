import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> queue = new LinkedList<>();
        
        for (int num : arr) {
            if (queue.isEmpty() || queue.peekLast() != num) {
                queue.add(num);
            }
        }
        
        int[] result = new int[queue.size()];
        int idx = 0;
        
        while (!queue.isEmpty()) {
            result[idx++] = queue.pollFirst();
        }
        
        return result;
    }
}