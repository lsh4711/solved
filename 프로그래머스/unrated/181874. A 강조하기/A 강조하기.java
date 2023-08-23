class Solution {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : myString.toCharArray()) {
            if (c == 'a') {
                c = 'A';
            } else if (65 < c && c <= 90) {
                c += 32;
            }
            sb.append(c);
        }
        
        return sb.toString();
    }
}