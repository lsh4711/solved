import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int[] result = Arrays.copyOfRange(num_list, n - 1, num_list.length);

        return result;
    }
}