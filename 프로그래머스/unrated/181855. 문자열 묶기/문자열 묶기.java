class Solution {
    public int solution(String[] strArr) {
        int[] lengths = new int[31];
        
        for (String str : strArr) {
            lengths[str.length()]++;
        }
        
        int max = 0;
        
        for (int length : lengths) {
            if (length > max) {
                max = length;
            }
        }
        
        return max;
    }
}