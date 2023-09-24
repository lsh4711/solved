class Solution {
    public int solution(int n, String[] data) {
        return dfs(new char[] {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'}, data, new boolean[8], "");
    }
    
    static int dfs(char[] friends, String[] data, boolean[] visits, String str) {
        if(str.length() == 8) return check(data, str);
        int cnt = 0;
        
        for(int i = 0; i < 8; i++) {
            if(visits[i]) continue;
            visits[i] = true;
            cnt += dfs(friends, data, visits, str + friends[i]);
            visits[i] = false;
        }
        
        return cnt;
    }
    
    static int check(String[] data, String str) {
        for(String d : data) {
            char me = d.charAt(0);
            char you = d.charAt(2);
            char op = d.charAt(3);
            int distance = d.charAt(4) - '0';
            int meIdx = -1;
            int youIdx = -1;
            for(int i = 0; i < 8; i++) {
                if(str.charAt(i) == me) meIdx = i;
                else if(str.charAt(i) == you) youIdx = i;
            }
            int abs = Math.abs(meIdx - youIdx);
            if(op == '<' && abs <= distance) continue;
            if(op == '>' && abs > distance + 1) continue;
            if(op == '=' && abs == distance + 1) continue;
            return 0;
        }
        
        return 1;
    }
} 