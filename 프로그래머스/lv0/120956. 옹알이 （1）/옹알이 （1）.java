class Solution {
    public int solution(String[] babbling) {
        int answer =0;
        
        for(String str : babbling) answer += str.replaceAll("aya|ye|woo|ma", "").equals("") ? 1 : 0;
        
        return answer;
    }
}