class Solution {
    public int[] solution(int[] arr) {
        int num = 1;
        
        while (num < arr.length) {
            num *= 2;
        }
        
        int[] result = new int[num];
        
        System.arraycopy(arr, 0, result, 0, arr.length);
        
        return result;
    }
}