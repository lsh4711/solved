class Solution {
    public int[] solution(int[] arr) {
        int length = 0;
        
        for (int num : arr) {
            length += num;
        }
        
        int idx = 0;
        int[] result = new int[length];
        
        for (int num : arr) {
            for (int i = 0; i < num; i++) {
                result[idx++] = num;
            }
        }
        
        return result;
    }
}