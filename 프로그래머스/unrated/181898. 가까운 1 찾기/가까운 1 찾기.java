class Solution {
    public int solution(int[] arr, int idx) {
        int result = -1;
        
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (num == 1 && i >= idx) {
                result = i;
                break;
            }
        }
        
        return result;
    }
}