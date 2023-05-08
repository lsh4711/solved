class Solution {
    public int[] solution(long begin, long end) {
        int[] result = new int[(int)(end - begin) + 1];
        
        for(int i = 1; i <= Math.min(end / 2, 10000000); i++) {
            for(int j = (int)Math.max((begin / i) * i, i + i); j <= end; j += i) {
                if(j < begin) continue;
                result[j - (int)begin] = i;
            }
        }
        
        return result;
    }
}  