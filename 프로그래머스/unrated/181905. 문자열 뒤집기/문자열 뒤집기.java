class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < my_string.length(); i++) {
            int idx = i < s || i > e ? i : e - i + s;
            sb.append(my_string.charAt(idx));
        }
        
        return sb.toString();
    }
}