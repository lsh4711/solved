import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<Integer[]> queue = new LinkedList<>();
        Integer[] copy = new Integer[priorities.length];
        
        for (int i = 0; i < priorities.length; i++) {
            int priority = priorities[i];
            queue.add(new Integer[] {i, priority});
            copy[i] = priority;
        }
        
        
        Arrays.sort(copy, (priority1, priority2) -> priority2 - priority1);
        
        int pointer = 0;
        int time = 0;
        
        while (!queue.isEmpty()) {
            Integer[] process = queue.removeFirst();
            if (process[1] != copy[pointer]) {
                queue.add(process);
                continue;
            }
            time++;
            pointer++;
            if (process[0] == location) {
                return time;
            }
        }
        
        return -1;
    }
}