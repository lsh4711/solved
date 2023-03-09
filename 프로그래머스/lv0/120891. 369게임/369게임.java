class Solution {
    public int solution(int order) {
        int answer = 0;
        
        for(; order>0; order/=10) {
            int num = order % 10;
            if(num%3 == 0 && num != 0) answer ++;
        }
        
        return answer;
    }
}