class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] result = new int[num_list.length];
            
        for (int i = 0; i < num_list.length; i++) {
            if (i < n) {
                result[num_list.length - n + i] = num_list[i];
            } else {
                result[i - n] = num_list[i];
            }
        }
            
        return result;
    }
}