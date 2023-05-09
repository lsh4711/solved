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
        label : for(String d : data) {
            char me = d.charAt(0);
            char you = d.charAt(2);
            char op = d.charAt(3);
            int start = 1;
            int end = d.charAt(4) - 47;
            int meIdx = -1;
            
            if(op == '=') start = end;
            else if(op == '<') end--;
            else {
                start = end + 1;
                end = 7;
            }
            for(int i = 0; i < 8; i++) {
                if(str.charAt(i) != me) continue;
                meIdx = i;
                break;
            }
            for(int i = start; i <= end; i++) {
                if(meIdx - i >= 0 && str.charAt(meIdx - i) == you) continue label;
                if(meIdx + i < 8 && str.charAt(meIdx + i) == you) continue label;
            }
            return 0;
        }
        
        return 1;
    }
}