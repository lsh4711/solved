class Solution {
    public int[] solution(int[] num_list) {
        int[] result = new int[num_list.length];
        
        for (int i = 0; i < num_list.length; i++) {
            result[result.length - i - 1] = num_list[i];
        }
        
        return result;
    }
}