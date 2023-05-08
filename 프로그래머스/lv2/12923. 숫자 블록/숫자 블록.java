class Solution {
    public int[] solution(long begin, long end) {
        int[] road = new int[(int)(end - begin) + 1];
        
        for(int i = 1; i <= Math.min(end / 2, 10000000); i++) {
            for(int j = (int)Math.max((begin - 1) / i + 1, 2) * i; j <= end; j += i) road[j - (int)begin] = i;
        }
        
        return road;
    }
}             