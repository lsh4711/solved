import java.util.Arrays;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        char[] arr = s.toCharArray();
        
        Arrays.sort(arr);
        label : for(char c : arr) {
            int cnt = 0;
            for(char cc : arr) {
                if(c != cc) continue;
                if(++cnt == 2) continue label;
            }
            answer.append(c);
        }
        
        return answer.toString();
    }
}