class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey != 0) {
            int num = storey % 10;
            storey /= 10;
            if (num > 5 || num == 5 && storey % 10 >= 5) {
                storey += 1;
                num = 10 - num;
            }
            answer += num;
        }
        
        return answer;
    }
}  