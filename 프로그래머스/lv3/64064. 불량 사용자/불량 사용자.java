import java.util.HashSet;

class Solution {
    static HashSet<String> set = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        dfs(user_id, banned_id, new String[banned_id.length], 0);
        
        return set.size();
    }
    
    static void dfs(String[] user_id, String[] banned_id, String[] users, int idx) {
        if (banned_id.length == idx) {
            sortAndAdd(users);
            return;
        }
        String ban = banned_id[idx];
        
        for (int i = 0; i < user_id.length; i++) {
            if(!isSame(user_id[i], ban)) {
                continue;
            }
            String tmp = user_id[i];
            users[idx] = tmp;
            user_id[i] = null;
            dfs(user_id, banned_id, users, idx + 1);
            user_id[i] = tmp;
        }
        
    }
    
    static boolean isSame(String user, String ban) {
        if (user == null || user.length() != ban.length()) {
            return false;
        }
        for (int i = 0; i < ban.length(); i++) {
            if (ban.charAt(i) != '*' && user.charAt(i) != ban.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
    
    static void sortAndAdd(String[] users) {
        boolean[] visits = new boolean[users.length];
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < users.length; i++) {
            String min = "";
            int minIdx = -1;
            for (int j = 0; j < users.length; j++) {
                String user = users[j];
                if (visits[j] || min.compareTo(user) >= 0) {
                    continue;
                }
                min = user;
                minIdx = j;
            }
            visits[minIdx] = true;
            sb.append(min);
        }
        
        set.add(sb.toString());
    }
}