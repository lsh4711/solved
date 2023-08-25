class Solution {
    public int solution(String str1, String str2) {
        boolean isContains = str2.contains(str1);
        
        if (isContains) {
            return 1;
        }
        return 0;
    }
}