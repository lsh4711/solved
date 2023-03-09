class Solution {
    public String solution(String my_string) {
        StringBuilder answer = new StringBuilder();

        for(char c : my_string.toCharArray()) {
            if(c>90) answer.append((char)(c-32));
            else answer.append((char)(c+32));
        }
        
        return answer.toString();
    }
}