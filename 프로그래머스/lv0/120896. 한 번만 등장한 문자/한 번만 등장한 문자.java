class Solution {
    public String solution(String s) {
        int[] visit = new int[123];
        StringBuilder answer = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) visit[s.charAt(i)]++;
        for(int i=65; i<123; i++) {
            if(visit[i] == 1) answer.append((char)i);
        }
        
        return answer.toString();
    }
}