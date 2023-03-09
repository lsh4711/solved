class Solution {
    public String solution(String my_string) {
        StringBuilder answer = new StringBuilder();
        
        label : for(char c : my_string.toCharArray()) {
            for(int i=0; i<answer.length(); i++) {
                if(answer.charAt(i) == c) continue label;
            }
            answer.append(c);
        }
        
        return answer.toString();
    }
}