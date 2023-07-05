import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

class Solution {
    public String[] solution(String[][] tickets) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for (String[] ticket : tickets) {
            map.putIfAbsent(ticket[0], new ArrayList<>());
            ArrayList<String> dests = map.get(ticket[0]);
            dests.add(ticket[1]);
        }
        for (Entry<String, ArrayList<String>> entry : map.entrySet()) {
            ArrayList<String> dests = entry.getValue();
            dests.sort(null);
        }

        String[] routes = new String[tickets.length + 1];
        
        return dfs(map, routes, "ICN", 0);
    }
    
    static String[] dfs(HashMap<String, ArrayList<String>> map, String[] routes, String now, int idx) {
        routes[idx] = now;

        if (idx + 1 == routes.length) {
            return routes;
        }

        ArrayList<String> dests = map.get(now);
        
        if (dests == null) {
            return null;
        }
        for (int i = 0; i < dests.size(); i++) {
            String dest = dests.get(i);
            if (dest == null) {
                continue;
            }
            String tmp = dest;
            dests.set(i, null);
            String[] result = dfs(map, routes, dest, idx + 1);
            dests.set(i, tmp);
            if (result != null) {
                return result;
            }
        }
        
        return null;
    }
}