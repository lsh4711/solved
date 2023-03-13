class Solution {
    public int solution(String before, String after) {
        int[] visit = new int[123];
        
        for(int i=0; i<before.length(); i++) {
            visit[before.charAt(i)]++;
            visit[after.charAt(i)]--;
        }
        for(int i=97; i<123; i++) {
            if(visit[i] != 0) return 0;
        }
        
        return 1;
    }
}