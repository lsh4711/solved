class Solution {
    public String solution(String my_string) {
        StringBuilder answer = new StringBuilder();
        
        for(int i=0; i<my_string.length(); i++) {
            char c = my_string.charAt(i);
            if(c>90) answer.append((char)(c-32));
            else answer.append((char)(c+32));
        }
        
        return answer.toString();
    }
}