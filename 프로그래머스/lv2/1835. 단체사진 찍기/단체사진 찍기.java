class Solution {
    public int solution(int n, String[] data) {
        // 모든 조합을 검증하는 방법으로 접근
        char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
            
        return dfs(friends, data, new boolean[8], "");
    }
    
    static int dfs(char[] friends, String[] data, boolean[] visits, String str) {
        if(str.length() == 8) return check(data, str); // 8명이 나열되었을떄 check로 검증하고 0 | 1 리턴
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
            char me = d.charAt(0); // 조건 제시한 친구
            char you = d.charAt(2); // 상대방
            char op = d.charAt(3); // 연산자
            int start = 1;
            int end = d.charAt(4) - 47; // -47 = (- '0' + 1)
            int meIdx = -1;
            
            if(op == '=') start = end; // 간격 = 2 -> start = 3
            else if(op == '<') end--;  // 간격 < 2 -> end = 2
            else {                                  // 간격 > 2 -> start = 4
                start = end + 1;
                end = 7;
            }
            for(int i = 0; i < 8; i++) { // 조건 제시한 친구 위치 탐색
                if(str.charAt(i) != me) continue;
                meIdx = i;
                break;
            }
            for(int i = start; i <= end; i++) { // 조건 제시한 친구 좌우로 조건 만족하는지 검증
                if(meIdx - i >= 0 && str.charAt(meIdx - i) == you) continue label;
                if(meIdx + i < 8 && str.charAt(meIdx + i) == you) continue label;
            }
            return 0; // continue label이 실행 안되고 도달했을 때 == 조건 충족 실패
        }
        
        return 1; // 여기까지 도달 == 조건이 최소 하나라도 만족
    }
}