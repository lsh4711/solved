class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 0;
        int range = w * 2 + 1;
        
        for (int i = 0; i < stations.length; i++) {
            int station = stations[i];
            int end = station - w - 1;
            answer += (end - start + range - 1) / range;
            start = station + w;
        }
        answer += (n - start + range - 1) / range;
        
        return answer;
    }
}