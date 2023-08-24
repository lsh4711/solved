class Solution {
    public int solution(int[] numbers, int n) {
        int result = 0;
        
        for (int number : numbers) {
            result += number;
            if (result > n) {
                break;
            }
        }
        
        return result;
    }
}