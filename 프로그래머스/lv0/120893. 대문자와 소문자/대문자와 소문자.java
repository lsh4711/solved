class Solution {
    public String solution(String my_string) {
        StringBuilder answer = new StringBuilder();

        for(char c : my_string.toCharArray()) {
            if(c>'Z') c-=32;
            else c+=32;
            answer.append(c);
        }
        
        return answer.toString();
    }
}
 