class Solution {
    public String solution(String my_string, String alp) {
        char point = alp.charAt(0);
        StringBuilder sb = new StringBuilder();
        
        for (char c : my_string.toCharArray()) {
            if (c == point) {
                c -= 32;
            }
            sb.append(c);
        }
        
        return sb.toString();
    }
}