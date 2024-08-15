class Solution {
    public int solution(int[] citations) {
        int[] counts = new int[10001];
        
        for (int citation : citations) {
            counts[citation]++;
        };
        
        int offset = 0;
        
        for (int i = counts.length - 1; i >= 0; i--) {
            offset += counts[i];
            if (offset >= i) {
                return i;
            }
        }
        
        return 0;
    }
}