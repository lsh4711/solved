class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        for(int num : array) {
            for(; num != 0; num /= 10) {
                if(num % 10 == 7) answer++;
            }
        } 
        
        return answer;
    }
}             