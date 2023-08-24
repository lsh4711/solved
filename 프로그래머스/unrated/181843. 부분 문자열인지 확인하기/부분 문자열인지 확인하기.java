class Solution {
    public int solution(String my_string, String target) {
        boolean isContains = my_string.contains(target);
        
        if (isContains) {
            return 1;
        }
        return 0;
    }
}