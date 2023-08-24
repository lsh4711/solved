class Solution {
    public int solution(String my_string, String is_prefix) {
        boolean isPrefix = my_string.startsWith(is_prefix);
        
        if (isPrefix) {
            return 1;
        }
        return 0;
    }
}