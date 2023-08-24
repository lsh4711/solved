class Solution {
    public int solution(String my_string, String is_suffix) {
        int idx = my_string.lastIndexOf(is_suffix);
        
        if (idx >= 0 && idx == my_string.length() - is_suffix.length()) {
            return 1;
        }
        return 0;
    }
}