import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < players.length; i++) map.put(players[i], i);
        for(String calling : callings) {
            int now = map.get(calling);
            String prevPlayer = players[now - 1];
            players[now - 1] = players[now];
            players[now] = prevPlayer;
            for(int j = now - 1; j <= now; j++) map.put(players[j], j);
        }
        
        return players;
    }
} 