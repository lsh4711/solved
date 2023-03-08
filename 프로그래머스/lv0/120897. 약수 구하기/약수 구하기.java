import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(int n) {
        ArrayList<Integer> answer = new ArrayList();
        
        for(int i=1; i<=n/2; i++) {
            if(n%i == 0) answer.add(i);
        }
        answer.add(n);
        
        return answer;
    }
}