class Solution {
    public int[] solution(int[] num_list, int n) {
        int idx = 0;
        int[] result = new int[(num_list.length - 1) / n + 1];
        
        for (int i = 0; i < result.length; i++) {
            result[i] = num_list[idx];
            idx += n;
        }
        
        return result;
    }
}