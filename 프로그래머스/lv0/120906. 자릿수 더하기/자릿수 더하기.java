class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(char c : Integer.toString(n).toCharArray()) answer += c - '0';
        
        return answer;
    }
}