class Solution {
    public double solution(int[] numbers) {
        int answer = 0;
        
        for(int i : numbers) answer += i;
        
        return (double)answer / numbers.length;
    }
}