class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] visit = new int[201];
        
        for(int[] line : lines) {
            for(int i=line[0]+101; i<=line[1]+100; i++) visit[i]++;
        }
        for(int i : visit) {
            if(i > 1) answer++;
        }
        
        return answer;
    }
}