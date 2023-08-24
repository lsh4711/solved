class Solution {
    public int solution(String my_string, String is_suffix) {
        boolean isSuffix = isSuffix(my_string, is_suffix);
        
        if (isSuffix) {
            return 1;
        }
        return 0;
    }
    
    static boolean isSuffix(String my_string, String is_suffix) {
        if (my_string.length() < is_suffix.length()) {
            return false;
        }
        
        int start = my_string.length() - is_suffix.length();
        
        for (int i = 0; i < is_suffix.length(); i++) {
            if (my_string.charAt(start++) != is_suffix.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
