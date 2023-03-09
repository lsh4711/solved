class Solution {
    public int solution(int[] array, int n) {
        int answer = array[0];
        
        for(int i=1; i<array.length; i++) {
            int num1 = Math.abs(answer-n);
            int num2 = Math.abs(array[i]-n);
            if(num1<num2) continue;
            if(num1 == num2) answer = Math.min(answer, array[i]);
            else answer = array[i];
        }
        
        return answer;
    }
} 