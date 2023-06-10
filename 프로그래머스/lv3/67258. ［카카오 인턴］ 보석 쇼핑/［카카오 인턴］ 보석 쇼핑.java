import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(String[] gems) {
        int idx = 0;
        int start = 0;
        int[] result = {0, gems.length};
        HashSet<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        
        for (String gem : gems) {
            set.add(gem);
        }
        while (true) {
            while (set.size() > map.size()) {
                if (idx == gems.length) {
                    result[0]++;
                    return result;
                }
                String gem = gems[idx++];
                map.put(gem, map.getOrDefault(gem, 0) + 1);
                queue.add(gem);
            }
            while (map.get(queue.peek()) > 1) {
                map.put(queue.peek(), map.get(queue.poll()) - 1);
                start++;
            }
            if (idx - start < result[1] - result[0]) {
                result[0] = start;
                result[1] = idx;
            }
            map.remove(queue.poll());
            start++;
        }
        
    }
}       