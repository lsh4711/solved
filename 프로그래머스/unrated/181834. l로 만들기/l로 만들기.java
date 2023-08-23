class Solution {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : myString.toCharArray()) {
            if (c < 'l') {
                c = 'l';
            }
            sb.append(c);
        }
        
        return sb.toString();
    }
}