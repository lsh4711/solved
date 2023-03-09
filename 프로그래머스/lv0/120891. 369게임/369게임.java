class Solution {
    public int solution(int order) {
        int answer = 0;
        
        for(; order>0; order/=10) {
            if(order%10 != 0 && order%10%3 == 0) answer ++;
        }
        
        return answer;
    }
}