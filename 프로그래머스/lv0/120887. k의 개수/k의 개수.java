class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
    
        for(int a=i; a<=j; a++) {
            int b = a;
            for(; b>0; b/=10) {
                if(b%10 == k) answer++;
            }
        }
        
        return answer;
    }
}