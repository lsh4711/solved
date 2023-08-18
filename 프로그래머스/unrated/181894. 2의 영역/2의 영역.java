class Solution {
    public int[] solution(int[] arr) {
        int left = -1;
        int right = -1;
        
        for (int i = 0; i < arr.length; i++) {
            int now = arr[i];
            if (now != 2) {
                continue;
            }
            if (left == -1) {
                left = i;
            }
            right = i;
        }
        
        if (left == -1) {
            return new int[] {-1};
        }

        int idx = 0;
        int size = right - left + 1;
        int[] result = new int[size];
        
        for (int i = left; i <= right; i++) {
            result[idx++] = arr[i];
        }
        
        return result;
    }
}