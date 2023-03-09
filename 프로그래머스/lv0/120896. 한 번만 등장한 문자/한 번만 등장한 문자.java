class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int[] visit = new int[123];
        
        for(int i=0; i<s.length(); i++) visit[s.charAt(i)]++;
        for(int i=65; i<123; i++) {
            if(visit[i] == 1) answer.append((char)i);
        }
        
        return answer.toString();
    }
}