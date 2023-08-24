class Solution {
    public int[] solution(int start, int end_num) {
        int idx = 0;
        int[] result = new int[start - end_num + 1];
        
        while (start >= end_num) {
            result[idx++] = start--;
        }
        
        return result;
    }
}