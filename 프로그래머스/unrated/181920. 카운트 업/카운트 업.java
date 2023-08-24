class Solution {
    public int[] solution(int start_num, int end_num) {
        int idx = 0;
        int[] result = new int[end_num - start_num + 1];
        
        while (start_num <= end_num) {
            result[idx++] = start_num++;
        }
        
        return result;
    }
}