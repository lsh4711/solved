class Solution {
    public int[] solution(int n, int k) {
        int idx = 0;
        int[] result = new int[n / k];
        
        for (int i = k; i <= n; i += k) {
            result[idx++] = i;
        }
        
        return result;
    }
}