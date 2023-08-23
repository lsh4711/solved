import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        int[] result = new int[5];
        
        Arrays.sort(num_list);
        for (int i = 0; i < 5; i++) {
            result[i] = num_list[i];
        }
        
        return result;
    }
}