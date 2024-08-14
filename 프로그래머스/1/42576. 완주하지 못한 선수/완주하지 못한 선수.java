import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String winner : completion) {
            int count = map.getOrDefault(winner, 0);
            map.put(winner, count + 1);
        }
        
        for (String runner : participant) {
            int count = map.getOrDefault(runner, 0);
            if (count == 0) {
                return runner;
            }
            map.put(runner, count - 1);
        }
        
        return null;
    }
}