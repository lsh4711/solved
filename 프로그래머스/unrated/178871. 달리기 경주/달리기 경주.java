import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < players.length; i++) map.put(players[i], i);
        for(String calling : callings) {
            int idx = map.get(calling);
            String left = players[idx - 1];
            String right = players[idx];
            map.put(left, idx);
            map.put(right, idx - 1);
            players[idx - 1] = right;
            players[idx] = left;
        }
        
        return players;
    }
}