class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        int length = 0;
        
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            length += end - start + 1;
        }
        
        int idx = 0;
        int[] result = new int[length];
        
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            for (int i = start; i <= end; i++) {
                int num = arr[i];
                result[idx++] = num;
            }
        }
        
        return result;
    }
}