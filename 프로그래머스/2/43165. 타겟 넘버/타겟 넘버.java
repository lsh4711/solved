class Solution {
    private int[] baseNumbers = {-1, 1};
    
    public int solution(int[] numbers, int target) {
        int result = dfs(numbers, target, 0, 0);
        return result;
    }
    
    private int dfs(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            return sum == target ? 1 : 0;
        }
        
        int result = 0;
        int number = numbers[index];
        
        for (int baseNumber : baseNumbers) {
            result += dfs(numbers, target, index + 1, sum + baseNumber * number);
        }
        
        return result;
    }
}