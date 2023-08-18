import java.util.Arrays;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        int[] result = null;
        
        if (n == 1) {
            result = Arrays.copyOf(num_list, b + 1);
        } else if (n == 2) {
            result = Arrays.copyOfRange(num_list, a, num_list.length);
        } else if (n == 3) {
            result = Arrays.copyOfRange(num_list, a, b + 1);
        } else {
            int idx = 0;
            int size = (b - a) / c + 1;
            result = new int[size];
            for (int i = a; i <= b; i += c) {
                result[idx++] = num_list[i];
            }
        }
        
        return result;
    }
}