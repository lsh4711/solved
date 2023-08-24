class Solution {
    public int solution(String num_str) {
        int result = 0;
        
        for (char num : num_str.toCharArray()) {
            result += num - '0';
        }
        
        return result;
    }
}