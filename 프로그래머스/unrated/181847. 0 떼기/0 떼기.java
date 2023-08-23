class Solution {
    public String solution(String n_str) {
        int start = 0;
        
        for (char c : n_str.toCharArray()) {
            if (c == '0') {
                start++;
            } else {
                break;
            }
        }
        
        return n_str.substring(start, n_str.length());
    }
}