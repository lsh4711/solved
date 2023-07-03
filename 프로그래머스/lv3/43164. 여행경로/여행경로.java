import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

class Solution {
    public String[] solution(String[][] tickets) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for (String[] ticket : tickets) {
            map.putIfAbsent(ticket[0], new ArrayList<>());
            ArrayList<String> list = map.get(ticket[0]);
            list.add(ticket[1]);
        }
        Set<String> keySet = map.keySet();
        
        for (String key : keySet) {
            ArrayList<String> list = map.get(key);
            list.sort(null);
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
        
        if (dests == null || dests.size() == 0) {
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