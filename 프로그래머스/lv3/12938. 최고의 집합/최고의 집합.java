class Solution {
    public int[] solution(int n, int s) {
        if (n > s) return new int[] {-1};
        int idx = 0;
        int splitN = s / n;
        int[] result = new int[n];
        
        while (n-- > 0) {
            if (s % (splitN + 1) == 0 && s / (splitN + 1) == result.length - idx) {
                splitN++;
            }
            result[idx++] = splitN;
            s -= splitN;
        }
        
        return result;
    }
}